package starcraft;

public class Tank extends GroundUnit implements Repairable, Attackable{
	protected Tank() {
		super("탱크", 300);
	}

	public void attack(Attackable unit) {
		Unit target = (Unit) unit;
		target.hp-=30;
	}
}
