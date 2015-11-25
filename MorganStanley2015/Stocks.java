import java.util.Scanner;

public class FiretRec {
	static int max = 0;
	static int N;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T;
		// System.out.println("hello1");
		T = sc.nextInt();
		while (T-- > 0) {
			N = sc.nextInt();

			int[] a = new int[N];
			for (int i = 0; i < N; i++) {
				a[i] = sc.nextInt();
			}
			max=0;
			Rec(1, a);
			
			System.out.println(max);
			// int sum = 0;
			//
			// int counter = (int) (N / 2) - 1;
			// // System.out.println("counter is " + counter);
			// for (int i = 0; i <= counter; i++) {
			// // System.out.println("Inside");
			// sum += Math.abs(a[i] - a[N - 1 - i]);
			// }
		}

	}

	public static void Rec(int index, int[] P) {
		if (index == N - 1) {

			int sum = 0;
			int counter = (int) (N / 2) - 1;

			// System.out.println("counter is " + counter);
			for (int i = 0; i <= counter; i++) {
				// System.out.println("Inside");
				sum += Math.abs(P[i] - P[N - 1 - i]);
			}
//
//			 for (int i = 0; i < N; i++) {
//			 System.out.print(P[i] + " ");
//			 }
//			 System.out.println();
//			 System.out.println("sum is " + sum);
			if (sum > max) {
				max = sum;
			}

			return;
		}

		if (P[index + 1] % 2 == 0 && P[index - 1] % 2 == 0) {
//			System.out.println(P[index + 1] + " and " + P[index - 1]
//					+ " are even");
			int[] A = new int[N];
			int[] B = new int[N];
			for (int i = 0; i < N; i++) {
				A[i] = B[i] = P[i];
			}
			int changeval = (P[index + 1] + P[index - 1]) / 2;
			B[index] = changeval;
			Rec(index + 1, A);
			Rec(index + 1, B);

		} else {
			int[] C = new int[N];
			for (int i = 0; i < N; i++) {
				C[i] = P[i];
			}
			Rec(index + 1, C);

		}

	}

}
