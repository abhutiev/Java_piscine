import java.util.Scanner;
import java.lang.String;

public class Program {

	private static String getValidatedLine (Scanner input) {
		String inputLine;

		inputLine = input.nextLine();
		if (inputLine.equals("42"))
			System.exit(-1);
		if (!inputLine.regionMatches(0, "Week", 0, 4)) {
			System.out.println("Illegal Argument");
			System.exit(-1);
		}
		return inputLine;
	}

	private static int getNumberofWeek(String weekLine) {
		String numberInString;
		numberInString = weekLine.split(" ")[1];
		if (numberInString.length() == 1) {
			return numberInString.charAt(0) - 48;
		}
		else {
			return numberInString.charAt(1) - 48 + 10;
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		String weekLine;
		int numberOfWeek = -1;
		while (true) {
			weekLine = getValidatedLine(input);
			numberOfWeek = getNumberofWeek(weekLine);
			System.out.println(numberOfWeek);
		}
	}

}