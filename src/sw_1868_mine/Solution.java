package sw_1868_mine;

import java.io.*;
import java.util.*;

// 계획: 0부터 찾고(하나당 클릭 한번), 나머지 빈칸을 click 수에 더한다.

public class Solution {

	static int[] dy = { -1, 1, 0, 0, 1, 1, -1, -1 };
	static int[] dx = { 0, 0, -1, 1, 1, -1, 1, -1 };
	static int N, click;
	static int[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			v = new boolean[N][N];
			click = 0;

			for (int i = 0; i < N; i++) {
				input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j);
				}
			}

			for (int i = 0; i < N; i++) {
				mine: for (int j = 0; j < N; j++) {
					if (map[i][j] == '*' || v[i][j]) {
						continue;
					}
					for (int k = 0; k < 8; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];

						if (ny >= 0 && nx >= 0 && ny < N && nx < N) {
							if (map[ny][nx] == '*') {
								continue mine;
							}
						}
					}
					v[i][j] = true;
					findZero(new xy(j, i));
					click++;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
					if (map[i][j] == '.') {
						click++;
					}
				}
				System.out.println();
			}
			sb.append("#" + t + " " + click + "\n");
		}
		System.out.println(sb);
	}

	// bfs로 나머지 다 찾기
	static void findZero(xy xy) {
		Queue<xy> q = new LinkedList<>();
		q.add(xy);
		while (!q.isEmpty()) {
			xy temp = q.poll();

			int mine = 0;
			// 주변에 마인 있는지 탐색
			for (int k = 0; k < 8; k++) {
				int ny = temp.y + dy[k];
				int nx = temp.x + dx[k];

				if (ny >= 0 && nx >= 0 && ny < N && nx < N) {
					if (map[ny][nx] == '*') {
						mine++;
					}
				}
			}

			map[temp.y][temp.x] = mine;

			// 없으면 주변 더 탐색
			if (map[temp.y][temp.x] == 0) {
				for (int k = 0; k < 8; k++) {
					int ny = temp.y + dy[k];
					int nx = temp.x + dx[k];

					if (ny >= 0 && nx >= 0 && ny < N && nx < N && !v[ny][nx]) {
						v[ny][nx] = true;
						q.add(new xy(nx, ny));
					}
				}
			}
		}
	}

	static class xy {
		int x, y;

		public xy(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}