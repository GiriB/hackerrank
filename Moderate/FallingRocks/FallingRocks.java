import java.util.Scanner;

public class FallingRocks {
	/**
	 * This program can be modified to also find the minimum number of jumps
	 * required to escape from the falling rocks
	 * 
	 * @param args
	 * @param flag
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int W, H;
		boolean flag = false;
		char ch = ' ';
		String S = "";
		W = sc.nextInt();
		H = sc.nextInt();
		

		boolean[][] A = new boolean[H + 2][W + 2];
		char[] B = new char[W + 2];

		for (int i = 1; i <= 1; i++) {
			S = sc.next();
			for (int j = 1; j <= W; j++) {
				ch = S.charAt(j - 1);
				B[j] = ch;
				if (ch == 'Y') {
					A[i][j] = true;
				} else {
					A[i][j] = false;
				}
			}
		}

		for (int i = 2; i <= H; i++) {
			S = sc.next();
			for (int j = 1; j <= W; j++) {
				ch = S.charAt(j - 1);
				if (ch == 'R') {
					// we can't come here
					A[i][j] = false;
					B[j] = 'R';
				} else if (ch == 'E') {
					// if its empty
					if ((B[j] == 'E' || B[j] == 'Y')
							&& (A[i - 1][j - 1] || A[i - 1][j] || A[i - 1][j + 1])) {
						A[i][j] = true;

					} else {
						A[i][j] = false;
					}
					B[j] = 'E';
				}

			}
		}

// prints the grid 
//		char out = ' ';
//		for (int i = 1; i <= H; i++) {
//			for (int j = 1; j <= W; j++) {
//
//				if (A[i][j]) {
//					ch = 'Y';
//				} else {
//					ch = 'N';
//				}
//				System.out.print(ch + " ");
//			}
//			System.out.println();
//		}

		for (int j = 1; j <= W; j++) {
			if (A[H][j]) {
				flag = true;
				break;
			}
		}

		if (flag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
