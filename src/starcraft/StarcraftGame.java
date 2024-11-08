package starcraft;

import java.util.ArrayList;
import java.util.Scanner;

public class StarcraftGame {
	private final int ATTACK = 1;
	private final int REPAIR = 2;
	private final int EXIT = 0;

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

	private boolean isRun = true;

	public void run() {
		set();
		while (isRun) {
			play();
		}
	}

	private void set() {
		list.add(tank);
		list.add(marine);
		list.add(scv);
		list.add(ship);
	}

	private void play() {
		printMenu();
		int sel = input("메뉴선택");

		switch (sel) {
		case ATTACK:
			attack();
		case REPAIR:
			repair();
		case EXIT:
			exit();
		}

	}

	private void printMenu() {
		System.out.println("1. 공격");
		System.out.println("2. 수리");
		System.out.println("0. 종료");
	}

	private void attack() {
		printUnit();
	}

	private void repair() {
		printUnit();
	}

	private void exit() {
		isRun = false;
		System.out.println("게임 종료.");
	}

	private void printUnit() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + ")" + list.get(i));
		}
	}

	private int input(String message) {
		System.out.print(message + " : ");
		String input = "";

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