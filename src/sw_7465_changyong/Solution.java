package sw_7465_changyong;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int N, M, p, q, answer;
	static int[] P;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			answer = 0;
			P = new int[N + 1];

			makeSet();

			for (int i = 0; i < M; i++) {
				input = br.readLine().split(" ");
				p = Integer.parseInt(input[0]);
				q = Integer.parseInt(input[1]);

				if (findSet(p) != findSet(q)) {
					union(p, q);
				}
			}

			for (int i = 1; i < N + 1; i++) {
				if (P[i] == i) {
					answer++;
				}
			}
			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}

	static int findSet(int a) {
		if (a == P[a]) {
			return a;
		}
		return P[a] = findSet(P[a]);
	}

	static void makeSet() {
		for (int i = 0; i < P.length; i++) {
			P[i] = i;
		}
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) {
			return false;
		}
		P[bRoot] = aRoot;
		return true;
	}
}
