package pl.wlochynski.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.wlochynski.models.CharacterType;
import pl.wlochynski.models.Player;
import pl.wlochynski.models.User;
import pl.wlochynski.repository.CharacterTypeRepository;
import pl.wlochynski.service.PlayerService;
import pl.wlochynski.service.UserService;
import pl.wlochynski.utilites.UserUtilites;

@Controller
public class StartGameController {

	@Autowired
	private CharacterTypeRepository characterTypeRepository;
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PlayerService playerService;
	
	@GET
	@RequestMapping(value = "/startGame")
	public String pickCharacter(Model model)
	{
		
		Map<String, CharacterType> mapOfCharacters = characterTypeRepository.getCharacterTypes();
		model.addAttribute("mapOfCharacters", mapOfCharacters);
		return "startGame";
	}
	
	
	@POST
	@RequestMapping(value= "/startGameForm")
	public String getCharacter(@RequestParam("character") String character, Model model) {
	
		
		User user = userService.findUserByEmail(UserUtilites.getLoggedUser());
		
		Player player = new Player();
		
		player.setUserId(user.getUserId());
		player.setCharacterType(character);
		
		CharacterType characterType = characterTypeRepository.getCharacterType(character);
		
		player.setDamage(characterType.getDamage());
		player.setAttackSpeed(characterType.getAttackSpeed());
		player.setHp(characterType.getHp());
		player.setDefense(characterType.getDefense());
		
		playerService.savePlayer(player);
		
		model.addAttribute("user",user);
		model.addAttribute("player",player);
		
		
		return "profil";
		
	}

}
