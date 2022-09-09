package sw_1238_contact;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input;

		for (int t = 1; t <= 10; t++) {
			input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int start = Integer.parseInt(input[1]);
			boolean[] visited = new boolean[N + 1];

			// 인접리스트 생성
			ArrayList<Integer>[] edge = new ArrayList[N + 1];
			for (int i = 0; i < N + 1; i++) {
				edge[i] = new ArrayList<Integer>();
			}
			input = br.readLine().split(" ");
			for (int i = 0; i < N / 2; i++) {
				edge[Integer.parseInt(input[i * 2])].add(Integer.parseInt(input[i * 2 + 1]));
			}

			// bfs 시동걸기
			Queue<node> q = new LinkedList<>();
			q.add(new node(start, 0));
			visited[start] = true;

			int maxLevel = 0, maxNum = start;

			// 본격 bfs
			while (!q.isEmpty()) {
				if (maxLevel < q.peek().level) {
					maxLevel = q.peek().level;
					maxNum = q.peek().num;
				}
				else if (maxLevel == q.peek().level && maxNum < q.peek().num) {
					maxNum = q.peek().num;
				}

				for (int i = 0; i < edge[q.peek().num].size(); i++) {
					if (visited[edge[q.peek().num].get(i)] == false) {
						visited[edge[q.peek().num].get(i)] = true;
						q.add(new node(edge[q.peek().num].get(i), q.peek().level + 1));
					}
				}
				q.poll();
			}
			sb.append("#" + t + " " + maxNum + "\n");
		}
		System.out.println(sb);
	}

	public static class node {
		int num, level;

		public node(int num, int level) {
			this.num = num;
			this.level = level;
		}
	}
}
