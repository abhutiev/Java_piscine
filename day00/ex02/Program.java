import java.util.Scanner;

public class Program {

	private static long sumOfDigits(long num) {
		if (num < 10)
			return num;
		else
			return num % 10 + sumOfDigits(num / 10);
	}

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

	public static void main(String[] args) {
		long counter = 0;
		Scanner input = new Scanner(System.in);
		long inputNumber;

		while (true)
		{
			inputNumber = input.nextLong();
			if (inputNumber == 42) {
				System.out.printf("Count of coffee-request - %d", counter);
				break;
			}
			if (isSimple(sumOfDigits(inputNumber)) < 0) {
				counter++;
			}
		}
		input.close();
	}
}
