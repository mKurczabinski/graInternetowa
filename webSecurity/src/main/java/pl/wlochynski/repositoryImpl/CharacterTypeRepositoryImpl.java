package pl.wlochynski.repositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pl.wlochynski.models.CharacterType;
import pl.wlochynski.repository.CharacterTypeRepository;

@Repository
public class CharacterTypeRepositoryImpl implements CharacterTypeRepository {

	private Map<String, CharacterType> mapOfCharacters = new HashMap<String, CharacterType>();
	
	public CharacterTypeRepositoryImpl() {
		CharacterType warrior = new CharacterType();
		warrior.setName("warrior");
		warrior.setAttackSpeed(1);
		warrior.setDamage(6);
		warrior.setHp(600);
		warrior.setDefense(1);
		
		CharacterType magic = new CharacterType();
		magic.setName("magic");
		magic.setAttackSpeed(1);
		magic.setDamage(6);
		magic.setHp(600);
		magic.setDefense(1);
		
		CharacterType ninja = new CharacterType();
		ninja.setName("ninja");
		ninja.setAttackSpeed(1);
		ninja.setDamage(6);
		ninja.setHp(600);
		ninja.setDefense(1);
		
		mapOfCharacters.put("warrior", warrior);
		mapOfCharacters.put("magic", magic);
		mapOfCharacters.put("ninja", ninja);
	}
	
	@Override
	public CharacterType getCharacterType(String characterName) {
		return mapOfCharacters.get(characterName);
		
	}
	
	@Override
	public Map<String, CharacterType> getCharacterTypes() {
		
		return mapOfCharacters;
	}

}
