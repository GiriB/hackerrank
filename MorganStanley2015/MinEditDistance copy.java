import java.util.Scanner;

class Anagram {
	String S;
	int L;
	int countpos = 0;
	int countneg = 0;
	int[] ch = new int[26];

	public Anagram minus(Anagram other) {
		int[] nch = new int[26];
		int countpos = 0;
		int countneg = 0;
		int ldash = this.L - other.L;
		String s = this.S + " - " + other.S;

		for (int i = 0; i < 26; i++) {
			nch[i] = this.ch[i] - other.ch[i];
			if (nch[i] < 0) {
				countneg += nch[i];
			} else {
				countpos += nch[i];
			}
		}

		countneg *= -1;
		return new Anagram(ldash, nch, s, countpos, countneg);

	}

	Anagram(int L, int ch[], String s, int cpos, int cneg) {
		this.S = s;
		this.countneg = cneg;
		this.countpos = cpos;
		this.L = L;
		this.ch = ch.clone();

	}

	public void print() {

		System.out.println("Printing for " + this.S + "with length" + this.L);
		for (int i : ch) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	Anagram(String s) {
		this.S = s;
		this.L = s.length();
		for (int i = 0; i < L; i++) {
			ch[((int) this.S.charAt(i)) - 97]++;
		}

	}
}

public class MinEditDistance {

	public static void main(String args[]) {

		int T;
		int delete, insert, replace;
		Scanner sc = new Scanner(System.in);
		String a = "", b = "";
		T = sc.nextInt();
		while (T-- > 0) {
			a = sc.next();
			b = sc.next();
			Anagram A1 = new Anagram(a);
			Anagram A2 = new Anagram(b);
			delete = sc.nextInt();
			insert = sc.nextInt();
			replace = sc.nextInt();
			Anagram na = A1.minus(A2);
//			A1.print();
//			A2.print();
//			na.print();

//			int countpos = 0;
//			int countneg = 0;
//			for (int i = 0; i < 26; i++) {
//				if (na.ch[i] < 0) {
//					countneg += na.ch[i];
//				} else {
//					countpos += na.ch[i];
//				}
//			}a
//
//			countneg *= -1;
			int result = 0;
			if (na.L > 0) {
				// we have to delete
				result = na.countneg * Math.min(replace, delete + insert)
						+ (na.countpos - na.countneg) * delete;

			} else if (na.L < 0) {
				// we have to insert
				result = insert * (na.countneg - na.countpos)
						+ Math.min(replace, insert + delete) * na.countpos;
			} else {
				// we have to just replace
				result = (na.countpos) * Math.min(replace, insert + delete);

			}
//			System.out.println("------------------->"+result);
			System.out.println(result);

		}
		// System.out.println(editDistance(a, b, delete, insert, replace));

	}
	// System.out.println(editDistance("abab", "acac"));
}

// public static void anagrams(String s1, String s2) {
//
// }
//
// // public static int editDistance(String s, String t, int delete, int
// // insert,
// // int replace) {
// // int m = s.length();
// // int n = t.length();
// //
// // int[][] d = new int[m + 1][n + 1];
// // for (int i = 0; i <= m; i++) {
// // d[i][0] = insert * i;
// // }
// // for (int j = 0; j <= n; j++) {
// // d[0][j] = delete * j;
// // }
// // for (int j = 1; j <= n; j++) {
// // for (int i = 1; i <= m; i++) {
// // if (s.charAt(i - 1) == t.charAt(j - 1)) {
// // d[i][j] = d[i - 1][j - 1];
// // } else {
// // d[i][j] = min((d[i - 1][j] + delete),
// // (d[i][j - 1] + insert), (d[i - 1][j - 1] + replace));
// // }
// // }
// // }
// // return (d[m][n]);
// // }
// //
// // public static int min(int a, int b, int c) {
// // return (Math.min(Math.min(a, b), c));
// // }
//
// }
