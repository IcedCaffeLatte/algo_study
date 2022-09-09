package boj_1260_DFSandBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, M, V;
	static ArrayList<Integer>[] edge;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		V = Integer.parseInt(input[2]);

		edge = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			edge[i] = new ArrayList<Integer>();
		}

		// 양방향
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			edge[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
			edge[Integer.parseInt(input[1])].add(Integer.parseInt(input[0]));
		}

		// 작은 번호의 간선으로 가기 위한 정렬
		for (int i = 0; i < N + 1; i++) {
			if (!(edge[i] == null)) {
				Collections.sort(edge[i]);
			}
		}

		// dfs
		visited = new boolean[N + 1];
		dfs(V);
		sb.append("\n");

		// bfs 구간
		visited = new boolean[N + 1];
		q.add(V);
		visited[V] = true;
		sb.append(V + " ");
		while (!q.isEmpty()) {
			for (int i = 0; i < edge[q.peek()].size(); i++) {
				if (visited[edge[q.peek()].get(i)] == false) {
					visited[edge[q.peek()].get(i)] = true;
					sb.append(edge[q.peek()].get(i) + " ");
					q.add(edge[q.peek()].get(i));
				}
			}
			q.poll();
		}

		System.out.println(sb);
	}

	static void dfs(int pos) {
		visited[pos] = true;
		sb.append(pos + " ");

		for (int i = 0; i < edge[pos].size(); i++) {
			if (visited[edge[pos].get(i)] == false) {
				dfs(edge[pos].get(i));
			}
		}
	}
}
