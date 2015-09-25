import java.util.Scanner;

public class TheCoinChangeProblem {
	public static void main(String args[]) {
		int Total, num;
		Scanner in = new Scanner(System.in);
		Total = in.nextInt();
		num = in.nextInt();
		int[] coins = new int[num + 1];

		for (int i = 1; i < num + 1; i++) {
			coins[i] = in.nextInt();
		}

		long [][] B = new long[num + 1][Total + 1];

		// If we have a non-zero Total to achieve with coins[0..0] coins
		for (int i = 1; i < Total + 1; i++) {
			B[0][i] = 0;
		}

		// If we have to achieve a Total=0 with any number of coins
		for (int i = 0; i < num + 1; i++) {
			B[i][0] = 1;
		}

		for (int i = 1; i < num + 1; i++) {
			for (int j = 1; j < Total + 1; j++) {
				// If the value of coin i is greeter than j, we can't pick it up
				if (coins[i] > j) {
					B[i][j] = B[i - 1][j];
				} else {
					B[i][j] = B[i - 1][j] + B[i][j - coins[i]];
				}
			}
		}

		System.out.println(B[num][Total]);

	}
}
