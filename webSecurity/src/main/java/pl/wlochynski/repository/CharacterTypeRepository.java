package pl.wlochynski.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pl.wlochynski.models.CharacterType;


@Repository("characterTypeRepository")
public interface CharacterTypeRepository {
	
	public Map<String, CharacterType> getCharacterTypes();
	
	public CharacterType getCharacterType(String characterName);
	
}
