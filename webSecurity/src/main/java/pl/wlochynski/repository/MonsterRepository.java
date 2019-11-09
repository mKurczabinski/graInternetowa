package pl.wlochynski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.wlochynski.models.Monster;

@Repository("monsterRepository")
public interface MonsterRepository extends JpaRepository<Monster, Integer> {

	public Monster findMonsterByLevel(Integer level);
}
