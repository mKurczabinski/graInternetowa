package pl.wlochynski.service;

import pl.wlochynski.models.Player;

public interface PlayerService {
	
	public Player findPlayerByUserId(Integer userId);
	public void savePlayer(Player player);

	/*
	 * public void updatePlayer(String column, Integer value, Integer userId);
	 * public void updatePlayer(String column, String value, Integer userId);
	 */
	public void updatePlayer(double attackSpeed, double damage, double hp, double defense, Integer level,  double exp, double wymaganyExp, Integer campaignLevel, Integer userId);
	public void updatePlayerExp(Integer exp, Integer userId);
}
