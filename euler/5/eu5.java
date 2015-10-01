import java.util.Scanner;

public class eu5 {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N;
		long prod;
		while (T-- > 0) {
			N = sc.nextInt();
			prod = N;

			while (!divideN(prod, N)) {
				prod += N;
			}
			System.out.println(prod);

		}
	}

	private static boolean divideN(long prod, int n) {
		for (int i = 2; i < n; i++) {
			if (prod % i != 0) {
				return false;
			}
		}

		return true;
	}
}
