package sw_3124_MinSpaningTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
	static int[] parent;
	static int V, E;
	static long answer;
	static PriorityQueue<edge> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		String[] input;

		for (int t = 1; t <= T; t++) {
			input = br.readLine().split(" ");
			V = Integer.parseInt(input[0]);
			E = Integer.parseInt(input[1]);
			answer = 0;
			parent = new int[V + 1];
			pq = new PriorityQueue<edge>();

			for (int i = 0; i < V + 1; i++) {
				parent[i] = i;
			}

			for (int i = 0; i < E; i++) {
				input = br.readLine().split(" ");
				// 우선순위 큐에 넣으면서 자동으로 가중치에 따라 정렬
				pq.add(new edge(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])));
			}

			for (int i = 0; i < E; i++) {
				edge temp = pq.poll();

				int a = find(temp.a);
				int b = find(temp.b);

				// 다른 유니온이면 유니온으로 묶으면서 가중치 추가
				if (a != b) {
					union(a, b);
					answer += temp.c;
				}
			}
			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}

	// 유니온 파인드
	public static int find(int num) {
		if (num == parent[num]) {
			return num;
		}
		parent[num] = find(parent[num]);
		return parent[num];
	}

	// 유니온
	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot != bRoot) {
			parent[aRoot] = b;
		}
		else {
			return;
		}
	}
}

class edge implements Comparable<edge> {
	int a;
	int b;
	int c;

	public edge(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	// 우선순위 큐에 들어올 때 마다 자동으로 정렬하는 기준을 만들어둔다
	// 여기선 가중치를 기준으로 정렬한다.
	@Override
	public int compareTo(edge arg) {
		return arg.c >= this.c ? -1 : 1;
	}
}