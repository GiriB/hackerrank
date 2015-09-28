import java.util.Scanner;

public class Candies {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		// total students
		int T;
		// total candies required
		T = sc.nextInt();
		// point scored by each student
		int[] P = new int[T];
		int[] C = new int[T];
		int TC = 0;
		for (int i = 0; i < T; i++) {
			P[i] = sc.nextInt();
		}
//		System.out.println("The point array is");
//		for (int i : P) {
//			System.out.print(i + " ");
//		}
//		System.out.println();

		C[0] = 1;
		TC = 1;
		//
		// // System.out.println("The candy array is");
		// // for (int i : C) {
		// // System.out.print(i + " ");
		// // }
		// //
		// // System.out.println();
		//
		for (int i = 1; i < T; i++) {
			if (P[i] > P[i - 1]) {
				C[i] = C[i - 1] + 1;
				TC += C[i];
			} else if (P[i] < P[i - 1]) {
				int temp = i;
				C[i] = 1;
				TC++;
				while ( temp!=0 && P[temp] < P[temp - 1] && C[temp] == C[temp - 1] && temp!=0 ) {
					C[temp - 1]++;
					TC++;
				
					temp--;
				}

			} else if (P[i] == P[i - 1]) {
				TC++;
				C[i] = 1;
			}

//			System.out.println("AFTER " + i);
//			for (int j : C) {
//				System.out.print(j + " ");
//			}
//
//			System.out.println("\n And TC is "+ TC);

		}

		System.out.println(TC);
//		System.out.println("The final candy array is");
//		for (int i : C) {
//			System.out.print(i + " ");
//		}
//
//		System.out.println();

		// for (int i = 0; i < T; i++) {
		// System.out.print(P[i] + " ");
		// }
		// System.out.println();
		// for (int i = 0; i < T; i++) {
		// System.out.print(candyArray[i] + " ");
		// }
		// System.out.println();
		// for (int i = 0; i < T; i++) {
		// System.out.print(consecutiveBiggerThan[i] + " ");
		// }
		// System.out.println();

	}
}
