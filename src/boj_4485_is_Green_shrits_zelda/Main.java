package boj_4485_is_Green_shrits_zelda;

// 우선순위 큐, 다익스트라

import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int[][] dijk;
	static int[] dy = { 0, 1, -1, 0 };
	static int[] dx = { 1, 0, 0, -1 };
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input;
		int t = 1;

		while (true) {
			N = Integer.parseInt(br.readLine().trim());

			// 0일때 탈출
			if (N == 0) {
				break;
			}

			map = new int[N][N];
			dijk = new int[N][N];

			for (int i = 0; i < N; i++) {
				input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(input[j]);
					dijk[i][j] = Integer.MAX_VALUE;
				}
			}

			sb.append("Problem " + t++ + ": " + dijkstra() + "\n");
		}
		System.out.println(sb);
	}

	public static int dijkstra() {
		PriorityQueue<point> pq = new PriorityQueue<point>();
		dijk[0][0] = map[0][0];
		pq.offer(new point(0, 0, map[0][0]));

		while (!pq.isEmpty()) {
			point p = pq.poll();

			for (int k = 0; k < 4; k++) {
				int nr = p.row + dy[k];
				int nc = p.col + dx[k];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (dijk[nr][nc] > dijk[p.row][p.col] + map[nr][nc]) {
						dijk[nr][nc] = dijk[p.row][p.col] + map[nr][nc];
						pq.offer(new point(nr, nc, dijk[nr][nc]));
					}
				}
			}
		}
		return dijk[N - 1][N - 1];
	}

	static class point implements Comparable<point> {

		int row, col, cost;

		public point(int row, int col, int cost) {
			this.row = row;
			this.col = col;
			this.cost = cost;
		}

		@Override
		public int compareTo(point o) {
			return this.cost - o.cost;
		}

	}
}
