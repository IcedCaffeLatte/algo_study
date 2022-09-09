package sw_3289_coprimeSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int N, M;
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
			P = new int[N];

			makeSet();
			
			sb.append("#" + t + " ");
			for (int i = 0; i < M; i++) {
				input = br.readLine().split(" ");
				if (input[0].equals("0")) {
					union(Integer.parseInt(input[1]),Integer.parseInt(input[2]));
				}
				if (input[0].equals("1")) {
					if (findSet(Integer.parseInt(input[1])) == findSet(Integer.parseInt(input[2]))) {
						sb.append("1");
					}
					else {
						sb.append("0");
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int findSet(int a) {
		if (a == P[a - 1]) {
			return a;
		}
		return P[a - 1] = findSet(P[a - 1]);
	}

	static void makeSet() {
		for (int i = 0; i < P.length; i++) {
			P[i] = i + 1;
		}
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) {
			return false;
		}
		P[bRoot - 1] = aRoot;
		return true;
	}
}