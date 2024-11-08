package starcraft;

import java.util.ArrayList;
import java.util.Scanner;

public class StarcraftGame {
	private Scanner sc = new Scanner(System.in);

	private static StarcraftGame instance = new StarcraftGame();

	public static StarcraftGame getInstance() {
		return instance;
	}

	private Tank tank = new Tank();
	private Marine marine = new Marine();
	private SCV scv = new SCV();
	private DropShip ship = new DropShip();
	ArrayList<Unit> list = new ArrayList<Unit>();

	public void run() {
		set();
		while (true) {
			play();
		}
	}

	private void play() {

		System.out.println(list.get(0));
	}

	private void set() {
		list.add(tank);
		list.add(marine);
		list.add(scv);
		list.add(ship);
	}

	private void attack() {

	}

	private void repair() {

	}

	private int input(String message) {
		System.out.print(message + " : ");
		String input = sc.nextLine();

		int number = -1;
		try {
			input = sc.nextLine();
			number = Integer.parseInt(input);
			return number;
		} catch (Exception e) {
			System.err.println("숫자를 입력하세요.");
			return number;
		}
	}

}