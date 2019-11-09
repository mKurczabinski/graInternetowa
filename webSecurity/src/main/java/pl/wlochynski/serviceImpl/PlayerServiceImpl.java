package pl.wlochynski.serviceImpl;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.wlochynski.models.Player;
import pl.wlochynski.models.Role;
import pl.wlochynski.models.User;
import pl.wlochynski.repository.PlayerRepository;
import pl.wlochynski.repository.RoleRepository;
import pl.wlochynski.repository.UserRepository;
import pl.wlochynski.service.PlayerService;
import pl.wlochynski.service.UserService;

@Service("PlayerService")
@Transactional
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired 
	private RoleRepository roleRepository;

	@Override
	public Player findPlayerByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return playerRepository.findPlayerByUserId(userId);
	}

	@Override
	public void savePlayer(Player player) {
		// TODO Auto-generated method stub
		playerRepository.save(player);
	}


	/*
	 * @Override public void updatePlayer(String column, Integer value, Integer
	 * userId) { // TODO Auto-generated method stub
	 * playerRepository.updatePlayer(column, value, userId); }
	 * 
	 * @Override public void updatePlayer(String column, String value, Integer
	 * userId) { // TODO Auto-generated method stub
	 * playerRepository.updatePlayer(column, value, userId); }
	 */

	@Override
	public void updatePlayer(double attackSpeed, 
			double damage,
			double hp,
			double defense,
			Integer level,
			double exp,
			double wymaganyExp,
			Integer campaignLevel,
			Integer userId) {
		// TODO Auto-generated method stub
		playerRepository.updatePlayer(attackSpeed, damage, hp, defense, level, exp, wymaganyExp, campaignLevel, userId);
	}
	@Override
	public void updatePlayerExp(Integer exp, Integer  userId) {
		playerRepository.updatePlayerExp(exp, userId);
	}




}