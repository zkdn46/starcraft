package starcraft;

public class Marine extends GroundUnit implements Attackable{
	protected Marine() {
		super("마린", 120);
	}
	
	public void attack(Unit unit) {
		unit.hp-=15;
	}
}
