package pl.wlochynski.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.wlochynski.models.CharacterType;
import pl.wlochynski.models.Monster;
import pl.wlochynski.repository.MonsterTypeRepository;

@Repository
public class MonsterTypeRepositoryImpl implements MonsterTypeRepository{

	private List<Monster> listOfMonsterTypes = new ArrayList<Monster>();	
	
	public MonsterTypeRepositoryImpl() {
		Monster monster = new Monster();
		monster.setId(0);
		monster.setName("monster");
		monster.setAttackSpeed(0.011);
		monster.setDamage(2.2);
		monster.setHp(220);
		monster.setDefense(0.011);
		monster.setArmorLevel(0.011);
		monster.setWeaponLevel(0.011);
		
	
		
		
		listOfMonsterTypes.add(monster);
	}
	
	@Override
	public Monster getMonsterType(Integer id) {
		// TODO Auto-generated method stub
		return listOfMonsterTypes.get(id);
	}

	@Override
	public Integer getNumberOfMonsterTypes() {
		// TODO Auto-generated method stub
		return listOfMonsterTypes.size();
	}

}
