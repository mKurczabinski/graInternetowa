package pl.wlochynski.repository;



import org.springframework.stereotype.Repository;

import pl.wlochynski.models.CharacterType;
import pl.wlochynski.models.Monster;

@Repository("monsterTypeRepository")
public interface MonsterTypeRepository {

	public Monster getMonsterType(Integer id);
	
	public Integer getNumberOfMonsterTypes();
}
