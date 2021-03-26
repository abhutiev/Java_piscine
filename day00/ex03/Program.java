import java.util.Scanner;
import java.lang.String;

public class Program {
	private static void printArrow(long grade) {
		for (int i = 0; i < grade; i++) {
			System.out.printf("=");
		}
		System.out.println(">");
	}
	private static void printProgress (long grades, int weekIndex) {
		long tenInPower = 1;

		for (int i = 1; i < weekIndex - 1; i++) {
			tenInPower *=10;
		}
		for (int i = 0; grades > 0; i++) {
			System.out.printf("Week %d ", i + 1);
			printArrow(grades / tenInPower);
			grades %= tenInPower;
			tenInPower /= 10;
		}
	}
	private static int getLowest (Scanner input) {
		int lowestGrade = input.nextInt();
		int buf;

		for (int i = 0; i < 4; i++) {
			buf = input.nextInt();
			if (buf < lowestGrade)
				lowestGrade = buf;
		}
		return lowestGrade;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String weekLine;
		int weekIndex = 1;
		int numberOfWeek;
		long grades = 0;

		while (true) {
			if (weekIndex== 19 || input.hasNext("42"))
				break;
			else if (input.hasNext("Week")) {
				weekLine = input.next("Week");
				if (input.hasNextInt()) {
					numberOfWeek = input.nextInt();
					if (weekIndex != numberOfWeek) {
						System.out.println("Invalid Argument");
						System.exit(-1);
					}
					grades = grades * 10 + getLowest(input);
					weekIndex++;
				}
				else {
					weekLine = input.nextLine();
					continue;
				}
			}
			else
				weekLine = input.nextLine();
		}
		printProgress(grades, weekIndex);
		input.close();
	}

}