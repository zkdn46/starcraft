package starcraft;

import java.util.ArrayList;
import java.util.Scanner;

public class StarcraftGame {
	private final int ATTACK = 1;
	private final int REPAIR = 2;
	private final int EXIT = 0;

	private final int TANK = 0;
	private final int MARINE = 1;
	private final int SCV = 2;
	private final int DROPSHIP = 3;

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

		if (sel == ATTACK) {
			attack();
		} else if (sel == REPAIR) {
			repair();
		} else if (sel == EXIT) {
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
		int sel = input("공격할 유닛 선택");
	}

	private void repair() {
		printUnit();
		int sel = input("수리 할 유닛 선택") - 1;

		if (sel < TANK || sel > DROPSHIP) {
			System.out.println("1~4 입력");
			return;
		}
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