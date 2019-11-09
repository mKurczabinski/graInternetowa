package pl.wlochynski.controller;

import java.util.Map;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.aspectj.weaver.bcel.AtAjAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.wlochynski.models.CharacterType;
import pl.wlochynski.models.Monster;
import pl.wlochynski.models.Player;
import pl.wlochynski.models.User;
import pl.wlochynski.repository.MonsterTypeRepository;
import pl.wlochynski.service.PlayerService;
import pl.wlochynski.service.UserService;
import pl.wlochynski.utilites.UserUtilites;

@Controller
public class CampaignController {

	@Autowired
	private MonsterTypeRepository monsterTypeRepository;

	@Autowired
	private PlayerService playerService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	private UserService userService;

	@GET
	@RequestMapping(value = "/campaign")
	public String startFight() {
		// wyswietlenie przeciwnika jako znak zapytania
		// button do ataku

		return "campaign";
	}

	@POST
	@RequestMapping(value = "/fight")
	public String fight(Model model) {
		
		double weaponLevel;
		double armorLevel;
		double hp;
		double dmg;
		double defense;
		double attackSpeed;

		User user = userService.findUserByEmail(UserUtilites.getLoggedUser());

		Player player = playerService.findPlayerByUserId(user.getUserId());
			
		
		
		Monster monster = monsterTypeRepository.getMonsterType(0);


		
		Random rnd = new Random();
		int tmp = rnd.nextInt(monsterTypeRepository.getNumberOfMonsterTypes());
		/*
		 * CharacterType charType = monsterTypeRepository.getMonsterType(tmp);
		 * monster.setMonsterType(charType.getName());
		 */
		
		
		if(player.getCampaignLevel()>5)
			tmp = rnd.nextInt(2)  + player.getCampaignLevel()+ 1;
		else if(player.getCampaignLevel()>10)
			tmp = rnd.nextInt(4)  + player.getCampaignLevel();
		else
			tmp = rnd.nextInt(1)  + player.getCampaignLevel()+ 1;
		monster.setLevel(tmp);
		weaponLevel = (1+(monster.getLevel()*monster.getWeaponLevel()));
		armorLevel = (1+(monster.getLevel()*monster.getArmorLevel()));
		attackSpeed = (1+(monster.getLevel()*monster.getAttackSpeed()));
		dmg = (monster.getLevel()*monster.getDamage());
		hp = (monster.getLevel() * monster.getHp());
		defense = ( 1+(monster.getLevel() *monster.getDefense()));

		double playerDefense = player.getHp() * player.getDefense() * player.getArmorLevel();
		double monsterDefense = hp * defense * armorLevel;
		double playerDamage = player.getDamage() * player.getWeaponLevel() * player.getAttackSpeed();
		double monsterDamage = dmg * weaponLevel * attackSpeed;
		//speed do kosza, dodac unik, moze przebicie i jakies lethality
		while (playerDefense > 0 && monsterDefense > 0) {
			monsterDefense -= playerDamage;
			if (monsterDefense > 0) {
				playerDefense -= monsterDamage;
			}
		}
		boolean fight = true;
		if (playerDefense <= 0) {
			fight = false;
		} else {
			player.setExp(player.getExp() + (monster.getLevel() * 100));
			player.setCampaignLevel(player.getCampaignLevel() +1);
			
			while (player.getExp() >= player.getWymaganyExp()) {
				player.setLevel(player.getLevel() + 1);
				player.setExp(player.getExp() - player.getWymaganyExp());
				player.setWymaganyExp(player.getWymaganyExp() * 1.5);
				
				player.setAttackSpeed(player.getAttackSpeed() + 0.01);
				player.setDamage(player.getDamage() + 2);
				player.setDefense(player.getDefense() + 0.01);
				player.setHp(player.getHp() + 200);
				
			}

			// level
			playerService.updatePlayer(player.getAttackSpeed(), player.getDamage(), player.getHp(), player.getDefense(),
					player.getLevel(), player.getExp(), player.getWymaganyExp(), player.getCampaignLevel(), player.getId());
		}

		model.addAttribute("hp", playerDefense);
		model.addAttribute("fight", fight);
		model.addAttribute("player", player);
		model.addAttribute("user", user);

		return "fight";
	}

}
