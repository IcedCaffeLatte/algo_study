package sw_1236_human_network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static boolean[] v;
	static int[] cc;
	static ArrayList<ArrayList<Integer>> edge;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		String[] input;

		for (int t = 1; t <= T; t++) {
			input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			int min = Integer.MAX_VALUE;
			cc = new int[N];

			edge = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				edge.add(new ArrayList<>());
			}

			for (int i = 0; i < N; i++) {
				for (int j = 1; j <= N; j++) {
					if (Integer.parseInt(input[i * N + j]) == 1) {
						edge.get(i).add(j-1);
					}
				}
			}

			for (int i = 0; i < N; i++) {
				bfs(i);
				min = Math.min(min, cc[i]);
			}

			sb.append("#" + t + " " + (min) + "\n");
		}
		System.out.println(sb);
	}

	static void bfs(int num) {
		v = new boolean[N];
		v[num] = true;
		Queue<person> q = new LinkedList<>();
		q.add(new person(num, 0));

		while (!q.isEmpty()) {
			person temp = q.poll();
			cc[num] += temp.distance;

			for (int i = 0; i < edge.get(temp.num).size(); i++) {
				if (!v[edge.get(temp.num).get(i)]) {
					v[edge.get(temp.num).get(i)] = true;
					q.add(new person(edge.get(temp.num).get(i), temp.distance + 1));
				}
			}
		}
	}

	static class person {
		int num;
		int distance;

		person(int num, int distance) {
			this.num = num;
			this.distance = distance;
		}
	}
}
