import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//We assume in the implementation that no self loops exist !

class node {
	int value;
	int weight;
	node next;

	node() {
		value = -1;
		weight = -1;
		next = null;
	}

	node(int a) {
		value = a;
		weight = -1;
		next = null;
	}
}

public class DFSing {

	static node[] graph = null;
	static int[] level;
	static int[] weight;

	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		int i = -1, j = -1;
		boolean enter = true;
		int num = scan.nextInt();
		int lines = scan.nextInt();

		// The graph is still null
		graph = new node[num];
		level = new int[num];

		// creating graph nodes and inserting values
		for (int c = 0; c < num; c++) {
			node n = new node(1);
			n.weight = scan.nextInt();
			graph[c] = n;
		}

		// AddingEdges
		for (int l = 0; l < lines; l++) {
			i = scan.nextInt();
			j = scan.nextInt();
			AddEdge(i - 1, j - 1);
//			System.out.println("going bfs");
			BFS();
			// PrintMinSum();
			// calucate min sum

		}

		// source and destination
		// i = scan.nextInt();
		// j = scan.nextInt();
		// BFS(i);
		//
		// if (level[j - 1] != -1) {
		// System.out.print(level[j - 1]);
		// } else {
		// System.out.print(0);
		// }

	}

	// private static void BFS(int v) {
	// v -= 1;// converting in index form
	//
	// for (int i = 0; i < level.length; i++) {
	// level[i] = -1;
	// }
	//
	// // Queue to store visited list
	// Queue<Integer> Q = new LinkedList<Integer>();
	// level[v] = 1;
	// Q.add(v);
	//
	// while (!Q.isEmpty()) {
	// int j = Q.remove();
	// node temp;
	// temp = graph[j];
	//
	// while (temp.next != null) {
	// if (level[temp.next.value - 1] == -1) {
	// level[temp.next.value - 1] = level[j];
	// Q.add(temp.next.value - 1);
	// }
	// temp = temp.next;
	// }
	// }
	//
	// // System.out.println(graph.length);
	// printlevel();
	//
	// }

	// private static void PrintMinSum() {
	// // TODO Auto-generated method stub
	// int min = graph[level[0]].sum;
	// for (int i = 0; i < level.length; i++) {
	// if (graph[level[i]].sum != -1 && graph[level[i]].sum < min) {
	// min = graph[level[i]].weight;
	// }
	// }
	// System.out.println(min);
	// }

	private static void printweight() {
		// TODO Auto-generated method stub
		for (node n : graph) {
			System.out.print(" " + n.weight);
		}
		System.out.println();

	}

	static void BFS() {

		for (int i = 0; i < level.length; i++) {
			level[i] = -1;
		}
		int minimum = Integer.MAX_VALUE;

		// BFS(1);
		for (int v = 0; v < graph.length; v++) {
			// Queue to store visited list
			// if v has not been visited before

			if (level[v] == -1) {
				// Queue to store visited list
				int tempweight = 0;
				Queue<Integer> Q = new LinkedList<Integer>();
				level[v] = v;
				Q.add(v);// MAX_INTEGER;

				while (!Q.isEmpty()) {
					int j = Q.remove();
					node temp;
					temp = graph[j];
					tempweight += graph[j].weight;
//					System.out.print("Starting from : " + j + " with weight "
//							+ tempweight + "\n Visited:");
					while (temp.next != null) {
						// tempweight += graph[j].weight;

						if (level[temp.next.value - 1] == -1) {
							level[temp.next.value - 1] = level[j];
							Q.add(temp.next.value - 1);
						}
						temp = temp.next;
					}
//					System.out.println();
					// printlevel();
				}
//				System.out.println(tempweight + " is the tempweight");

				if (tempweight < minimum) {
					minimum = tempweight;
				}
			}
		}

//		printlevel();
		System.out.println(minimum);
//		printweight();

	}

	static void printlevel() {
		for (int j : level) {
			System.out.print(j + " ");
		}
		System.out.println();

	}

	private static void AddEdge(int i, int j) {
		// TODO Auto-generated method stub

		// create vertices
		node t1 = new node(i + 1);
		node t2 = new node(j + 1);

		// checking if null
		if (graph[i] == null) {
			System.out.println("This should never happen");
			graph[i] = new node(1);
		}
		if (graph[j] == null) {
			System.out.println("This should never happen");
			graph[j] = new node(1);
		}

		node temp;

		// ADDING IN i
		temp = graph[i];

		while (temp.next != null) {
			temp = temp.next;

			// checking if edge already present
			if (temp.value == j + 1) {
				return;
			}
		}

		if (temp.next == null && temp.value != j + 1) {
			temp.next = t2;
		}

		// ADDING IN j
		temp = graph[j];

		while (temp.next != null) {
			temp = temp.next;

			// checking if edge already present
			if (temp.value == i + 1) {
				return;
			}
		}

		if (temp.next == null && temp.value != i + 1) {
			temp.next = t1;
		}

		// EDGE COMPLETE
	}
}
