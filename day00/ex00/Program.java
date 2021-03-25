public class Program {

	public static int last_digit(int num) {
		if (num < 10)
			return num;
		else
			return num % 10 + last_digit(num / 10);
	}

	public static void main(String[] args) {
		int number = 151511;
		int result = 0;

		result += number / 100000;
		number = number % 100000;
		result += number / 10000;
		number = number % 10000;
		result += number / 1000;
		number = number % 1000;
		result += number / 100;
		number = number % 100;
		result += number / 10;
		number = number % 10;
		result += number / 10;
		result += number % 10;
//		result = last_digit(number);
 		System.out.print(result);
	}
}
