package condition.test;

public class ConditionTest5 {

	public static void main(String[] args) {
		int dice = (int) (Math.random() * 6) + 1;// 1~6 사이의 랜덤한 정수가 할당되도록
		/*
		 * 1이면 Dice1
		 */

		/*
		 * if(dice==1) { System.out.println("Dice1"); } else if(dice==2) {
		 * System.out.println("Dice2"); } else if(dice==3) {
		 * System.out.println("Dice3"); } else if(dice==4) {
		 * System.out.println("Dice4"); } else if(dice==5) {
		 * System.out.println("Dice5"); } else { System.out.println("Dice6"); }
		 */

		switch (dice) {
		case 1:
			System.out.println("Dice1");
			break;
		case 2:
			System.out.println("Dice2");
			break;
		case 3:
			System.out.println("Dice3");
			break;
		case 4:
			System.out.println("Dice4");
			break;
		case 5:
			System.out.println("Dice5");
			break;
		default:
			System.out.println("Dice6");
		}

	}

}
