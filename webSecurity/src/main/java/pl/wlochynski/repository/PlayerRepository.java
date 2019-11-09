package pl.wlochynski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.wlochynski.models.Player;

@Repository("playerRepository")
public interface PlayerRepository extends JpaRepository<Player, Integer> {
	
	public Player findPlayerByUserId(Integer userId);
	
	@Modifying
	@Query("UPDATE Player SET  exp = :value WHERE userId= :userId") public
	void updatePlayerExp(@Param("value") double value, @Param("userId") Integer userId);
	
	@Modifying
	@Query("UPDATE Player SET campaignLevel = :value WHERE userId= :userId") public
	void updatePlayerCampaignLevel(@Param("value") double value, @Param("userId") Integer userId);
	  
	@Modifying
	@Query("UPDATE Player SET title = :value WHERE userId= :userId") public
	void updatePlayerTitle(@Param("value") double value, @Param("userId") Integer userId);
	
	@Modifying
	@Query("UPDATE Player SET weaponLevel = :value WHERE userId= :userId") public
	void updatePlayerWeaponLevel(@Param("value") double value, @Param("userId") Integer userId);
	  
	@Modifying
	@Query("UPDATE Player SET  armorLevel = :value WHERE userId= :userId") public
	void updatePlayerArmorLevel(@Param("value") Integer value, @Param("userId") Integer userId);
	
	@Modifying
	@Query("UPDATE Player SET attackSpeed = :value WHERE userId= :userId") public
	void updatePlayerAttackSpeed(@Param("value") Integer value, @Param("userId") Integer userId);
	  
	@Modifying
	@Query("UPDATE Player SET  damage = :value WHERE userId= :userId") public
	void updatePlayerDamage(@Param("value") double value, @Param("userId") Integer userId);
	
	@Modifying
	@Query("UPDATE Player SET hp = :value WHERE userId= :userId") public
	void updatePlayerHp(@Param("value") double value, @Param("userId") Integer userId);
	  
	@Modifying
	@Query("UPDATE Player SET  defense = :value WHERE userId= :userId") public
	void updatePlayerDefense(@Param("value") double value, @Param("userId") Integer userId);
	
	@Modifying
	@Query("UPDATE Player p SET p.attackSpeed = :attackSpeed, p.damage = :damage, p.hp = :hp,"
			+ " p.defense = :defense, p.level = :level, p.exp = :exp, "
			+ "p.wymaganyExp =:wymaganyExp, p.campaignLevel =:campaignLevel WHERE p.userId = :userId")
	public void updatePlayer(@Param("attackSpeed") double attackSpeed,
			@Param("damage") double damage,
			@Param("hp") double hp,
			@Param("defense") double defense,
			@Param("level") Integer level,
			@Param("exp") double exp, 
			@Param("wymaganyExp") double wymaganyExp, 
			@Param("campaignLevel") Integer campaignLevel,
			@Param("userId") Integer userId);
}
