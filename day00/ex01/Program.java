import java.util.Scanner;

public class Program {
	private static long isSimple(long num) {
		if (num < 2) {
			return 0;
		}
		long i;
		for (i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return i - 1;

		}
		return -i + 1;
	}

	public static void main(String[] atgs) {
		Scanner input = new Scanner(System.in);
		long inputNumber = input.nextLong();
		long result = isSimple(inputNumber);

		if (result == 0) {
			System.out.print("Illegal Argument");
			System.exit(-1);
		}
		else if (result < 0) {
			System.out.printf("true %d", -result);
		}
		else {
			System.out.printf("false %d", result);
		}
		input.close();

	}
}