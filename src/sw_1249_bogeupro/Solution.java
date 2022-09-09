package sw_1249_bogeupro;

// 우선순위큐, bfs 사용

import java.io.*;
import java.util.*;

public class Solution {
	static int dy[] = { 0, 1, 0, -1 };
	static int dx[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		String temp;
		int answer = 0;

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine().trim());

			int[][] map = new int[N][N];
			boolean[][] v = new boolean[N][N];
			answer = 0;

			for (int i = 0; i < N; i++) {
				temp = br.readLine().trim();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp.charAt(j) - '0';
				}
			}
			
			//우선순위큐로 주변에서 값이 가장 작은 것 위주로 탐색
			PriorityQueue<xyc> pq = new PriorityQueue<>();
			pq.add(new xyc(0, 0, 0));

			while (!pq.isEmpty()) {
				xyc txyc = pq.poll();
				
				// 끝 도착
				if (txyc.x == N - 1 && txyc.y == N - 1) {
					// 우선순위큐로 달렸기 때문에
					// 가장 작은 값이 출력될 것
					answer = txyc.c;
					break;
				}
				
				// 사방위 탐색
				for (int i = 0; i < 4; i++) {
					int ny = txyc.y - dy[i];
					int nx = txyc.x - dx[i];

					if (ny >= 0 && nx >= 0 && nx < N && ny < N && v[ny][nx] == false) {
						v[ny][nx] = true;
						pq.offer(new xyc(nx, ny, txyc.c + map[ny][nx]));
					}
				}
			}

			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}
}

class xyc implements Comparable<xyc> {
	int x, y, c;

	public xyc(int x, int y, int c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}

	@Override
	public int compareTo(xyc o) {
		return this.c - o.c;
	}
}