import java.util.Scanner;
import java.lang.String;

public class Program {
	private static int columnHeight(int frequency, int maxFrequency) {
		return frequency * 10 / maxFrequency;
	}
	private static String numberOfDigits(int num) {
		if (num >= 100)
			return "   ";
		if (num >= 10)
			return "  ";
		return " ";
	}
	private static void insertIfBigEnough(int[] listOfMostFrequent, int Frequency, char[] listOfMostFrequentChar, char index) {
		for (int i = 9; i >= 0; i--) {
			if (Frequency > listOfMostFrequent[i]) {
				for (int j = 0; j < i; j++) {
					listOfMostFrequent[j] = listOfMostFrequent[j + 1];
					listOfMostFrequentChar[j] = listOfMostFrequentChar[j + 1];
				}
				listOfMostFrequent[i] = Frequency;
				listOfMostFrequentChar[i] = index;
				break;
			}
		}
	}
	private static char[] createLine(int index, int number) {
		char[] res = new char[12];

		for (int i = 0; i < 12; i++)
			res[i] = ' ';
		res[index] = (char)(number + 48);
		return res;
	}
	private static char[] createEmptyLine() {
		char[] res = new char[12];

		for (int i = 0; i < 12; i++)
			res[i] = ' ';
		return res;
	}
	private static void formOutput(int[] number, char[] characters) {
		char[][] output = new char[10][];
		int i;
		int j;

		for (i = 0; i < 10; i++) {
			output[i] = new char[12];
		}
		for (i = 9; i >= 0 && number[i] != 0; i--) {
			for (j = 0; j < 11; j++) {
				if (j < 10 - columnHeight(number[i], number[9]))
					output[i][j] = ' ';
				else
					output[i][j] = '#';
			}
			output[i][10 - columnHeight(number[i], number[9])] = (char) ((int) number[i] % 10 + 48);
			output[i][11] = characters[i];
		}
		char[][] final_output = new char[40][];
		for (i = 0; i < 40; i++) {
			final_output[i] = new char[40];
		}
		j = 0;
		for (i = 0; i < 10; i++) {
			final_output[j] = createEmptyLine();
			j++;
			final_output[j] = output[i];
			j++;
			if (number[i] >= 10) {
				final_output[j] = createLine(10 - columnHeight(number[i], number[9]), (number[i] % 100) / 10);
				j++;
			}
			if (number[i] >= 100) {
				final_output[j] = createLine(10 - columnHeight(number[i], number[9]), (number[i] / 100));
				j++;
			}
		}
		for (i = 0; i < 12; i++) {
			for (int k = 0; k < j; k++) {
				System.out.print(final_output[j - k][i]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char[] line = input.nextLine().toCharArray();
		int[] frequensyOfAll = new int[65355];
		int[] mostFrequent = new int[10];
		char[] mostFrequentChar = new char[10];
		String[] output = new String[12];

		for (int i = 0; i < line.length; i++) {
			frequensyOfAll[line[i]] += 1;
		}
		for (int i = 0; i < 65355; i++) {
			insertIfBigEnough(mostFrequent, frequensyOfAll[i], mostFrequentChar, (char)i);
		}
		formOutput(mostFrequent, mostFrequentChar);
		input.close();
	}
}
//test 1223334444555556666667777777888888889999999990000000000