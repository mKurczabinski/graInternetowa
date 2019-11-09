package pl.wlochynski.models;

public class CharacterType {
	private int id;
	private String name;
	private double attackSpeed;
	private double damage;
	private double hp;
	private double defense;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
	
}
