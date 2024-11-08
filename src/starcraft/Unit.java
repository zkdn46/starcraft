package starcraft;

abstract public class Unit {
	protected final int MAX_HP;
	protected int hp;
	protected String name;

	protected Unit(String name, int hp) {
		MAX_HP = hp;
		this.hp = hp;
		this.name = name;
	}
}