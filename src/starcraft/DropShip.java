package starcraft;

public class DropShip extends AirUnit implements Repairable {
	protected DropShip() {
		super("드랍십", 200);
	}

	void fly() {
		System.out.println("비행 중");
	}
}
