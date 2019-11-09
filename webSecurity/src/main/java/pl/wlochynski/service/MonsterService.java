package pl.wlochynski.service;

import pl.wlochynski.models.Monster;

public interface MonsterService {
	public Monster findMonsterByLevel(Integer level);

}
