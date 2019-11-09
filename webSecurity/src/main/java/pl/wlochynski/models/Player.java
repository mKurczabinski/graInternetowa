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
@Table(name = "player")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "userId")
	private int userId;

	@Column(name = "exp")
	@NotNull
	private double exp = 0;

	@Column(name = "characterType")
	@NotNull
	private String characterType;

	@Column(name = "campaignLevel")
	private int campaignLevel = 1;

	@Column(name = "title")
	private String title = "Beginner";

	@Column(name = "weaponLevel")
	private double weaponLevel = 1;

	@Column(name = "armorLevel")
	private double armorLevel = 1;

	@Column(name = "attackSpeed")
	private double attackSpeed = 1;

	@Column(name = "damage")
	private double damage = 2;

	@Column(name = "hp")
	private double hp = 200;

	@Column(name = "defense")
	private double defense = 0;

	@Column(name = "wymaganyExp")
	private double wymaganyExp = 100;

	@Column(name = "level")
	private int level = 1;

	public double getWymaganyExp() {
		return wymaganyExp;
	}

	public void setWymaganyExp(double wymaganyExp) {
		this.wymaganyExp = wymaganyExp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCampaignLevel() {
		return campaignLevel;
	}

	public void setCampaignLevel(int campaignLevel) {
		this.campaignLevel = campaignLevel;
	}

	public String getCharacterType() {
		return characterType;
	}

	public void setCharacterType(String characterType) {
		this.characterType = characterType;
	}

	public String getTitle() {
		return title;
	}

	public double getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(double attackSpeed) {
		this.attackSpeed = attackSpeed;
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

	public void setTitle(String title) {
		this.title = title;
	}

	public double getExp() {
		return exp;
	}

	public void setExp(double exp) {
		this.exp = exp;
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