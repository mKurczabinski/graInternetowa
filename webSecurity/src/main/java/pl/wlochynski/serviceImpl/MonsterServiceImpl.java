package pl.wlochynski.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.wlochynski.models.Monster;
import pl.wlochynski.repository.MonsterRepository;
import pl.wlochynski.service.MonsterService;

@Service("monsterService")
@Transactional
public class MonsterServiceImpl implements MonsterService {

	@Autowired
	private MonsterRepository monsterRepository;
	
	@Override
	public Monster findMonsterByLevel(Integer level) {
		// TODO Auto-generated method stub
		return monsterRepository.findMonsterByLevel(level);
	}
}
