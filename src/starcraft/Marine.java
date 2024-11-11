package starcraft;

public class Marine extends GroundUnit implements Attackable{
	protected Marine() {
		super("마린", 120);
	}
	
	public void attack(Attackable unit) {
		Unit target = (Unit) unit;
		target.hp-=15;
	}
}
