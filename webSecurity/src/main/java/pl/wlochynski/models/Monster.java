package pl.wlochynski.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "monster")
public class Monster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "level")
	@NotNull
	private int level;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "monsterType")
	@NotNull
	private String monsterType;

	@Column(name = "weaponLevel")
	private double weaponLevel;

	@Column(name = "armorLevel")
	private double armorLevel;
	
	@Column(name = "attackSpeed")
	private double attackSpeed;
	
	@Column(name = "damage")
	private double damage;
	
	@Column(name = "hp")
	private double hp;

	@Column(name = "defense")
	private double defense;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(double d) {
		this.attackSpeed = d;
	}

	public double getDamage() {
		return damage;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}

	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	public double getDefense() {
		return defense;
	}

	public void setDefense(double defense) {
		this.defense = defense;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMonsterType() {
		return monsterType;
	}

	public void setMonsterType(String monsterType) {
		this.monsterType = monsterType;
	}

	public double getArmorLevel() {
		return armorLevel;
	}

	public void setArmorLevel(double armorLevel) {
		this.armorLevel = armorLevel;
	}

	public double getWeaponLevel() {
		return weaponLevel;
	}

	public void setWeaponLevel(double weaponLevel) {
		this.weaponLevel = weaponLevel;
	}

}