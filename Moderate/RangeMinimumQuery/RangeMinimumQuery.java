package HR;

import java.util.Scanner;

class Node {
	Node right = null;
	Node left = null;
	String range;
	int value;
}

public class RangeMinimumQuery {
	private static final int OUTCAST_NUMBER = 1000000;
	static int[] VAL;

	public static void main(String args[]) {
		int N;
		int M;
		Scanner sc = new Scanner(System.in);

		// N - number of elements
		// M - number of queries
		N = sc.nextInt();
		M = sc.nextInt();

		// Read values
		VAL = new int[N];
		for (int i = 0; i < N; i++) {
			VAL[i] = sc.nextInt();
		}

		// Root node
		Node root = new Node();

		// Create Segment Tree
		createSegmentTree(0, N - 1, root);

		// for debugging
		// printTree(root);

		// Variables to store query arguments
		int a, b;
		for (int i = 0; i < M; i++) {
			a = sc.nextInt();
			b = sc.nextInt();

			//Get the answer in O(logN)
			System.out.println(searchTree(0, N - 1, a, b, root));
		}

	}

	private static int searchTree(int l, int r, final int a, final int b,
			Node root) {
		// TODO Auto-generated method stub

		int mid = (l + r) / 2;

		if (l >= a && r <= b) {
			// Exact match. we return current value
			return root.value;
		} else if (l > b || r < a) {
			// we are out of range so we return a INVALID number
			return OUTCAST_NUMBER;
		} else if (a > mid) {
			// we go complete right

			return searchTree(mid + 1, r, a, b, root.right);
		} else if (b < mid) {
			// we go complete left

			return searchTree(l, mid, a, b, root.left);
		} else {
			// we go both ways

			// CHANGE HERE
			return Math.min(searchTree(l, mid, a, b, root.left),
					searchTree(mid + 1, r, a, b, root.right));
		}

	}

	private static int createSegmentTree(int l, int r, Node root) {

		// for debugging
		root.range = l + " - " + r;
		int mid;

		if (l == r) {
			return root.value = VAL[l];
		} else {
			root.right = new Node();
			root.left = new Node();

			mid = (l + r) / 2;
			int a = createSegmentTree(l, mid, root.left);
			int b = createSegmentTree(mid + 1, r, root.right);

			// CHANGE HERE
			root.value = Math.min(a, b);
			return root.value;
		}

	}

	private static void printTree(Node root) {
		if (root != null) {
			System.out.println(root.range + " " + root.value);
			printTree(root.left);
			printTree(root.right);
		}
	}

}
