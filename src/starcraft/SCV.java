package starcraft;

public class SCV extends GroundUnit implements Repairable {
	protected SCV() {
		super("SCV", 100);
	}

	protected void repair(Repairable unit) {
		Unit target = (Unit) unit;

		while (target.hp!=target.MAX_HP) {
			target.hp++;
			String msg = String.format("%s 수리중 [%d/%d]", target.name, target.hp, target.MAX_HP);
			System.out.println(msg);

			try {
				Thread.sleep(200);
			} catch (Exception e) {
			}
		}
		System.out.println("수리 완료");

	}
}
