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
	private ArrayList<Unit> list = new ArrayList<Unit>();

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
		int me = input("공격할 유닛 선택") - 1;
		int you = input("공격당할 유닛 선택") - 1;

		if ((me == TANK || me == SCV) && you == DROPSHIP) {
			System.out.println("공중 유닛은 공격 할 수 없습니다.");
			return;
		}

		if (me == TANK) {
			tank.attack((Attackable) list.get(you));
		} else if (me == MARINE) {
			marine.attack((Attackable) list.get(you));
		} else if (me == SCV) {
			scv.attack((Attackable) list.get(you));
		} else if (me == DROPSHIP) {
			System.out.println("공격이 불가한 유닛입니다.");
		}

		if (list.get(you).hp <= 0) {
			list.get(you).hp = 0;
			System.out.println(list.get(you).name + " 사망");
		}
		System.out.println(list.get(you));
	}

	private void repair() {
		printUnit();
		int sel = input("수리 할 유닛 선택") - 1;

		if (sel < TANK || sel > DROPSHIP) {
			System.out.println("1~4 입력");
			return;
		}

		if (sel == TANK) {
			scv.repair(tank);
		} else if (sel == MARINE) {
			System.out.println("이 유닛은 수리가 불가능합니다.");
		} else if (sel == SCV) {
			scv.repair(scv);
		} else if (sel == DROPSHIP) {
			scv.repair(ship);
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