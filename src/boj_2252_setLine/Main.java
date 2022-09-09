package boj_2252_setLine;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		int[] indegree = new int[N + 1];
		List<Integer>[] line = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			line[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			line[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
			indegree[Integer.parseInt(input[1])]++;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				pq.offer(i);
			}
		}
		
		while (!pq.isEmpty()) {
			int cur = pq.poll();
			sb.append(cur + " ");
			for (int next : line[cur]) {
				indegree[next]--;
				if (indegree[next] == 0)
					pq.offer(next);
			}
		}
		
		System.out.println(sb.substring(0, sb.length() - 1));
	}
}
