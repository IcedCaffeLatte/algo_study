package sw_1953_prisonBreak;

import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, X, Y, TIME, answer;
	static int[][] map;
	static boolean[][] v;
	static int dy[] = { 0, 1, 0, -1 };
	static int dx[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		String[] input;

		for (int t = 1; t <= T; t++) {
			input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			Y = Integer.parseInt(input[2]);
			X = Integer.parseInt(input[3]);
			TIME = Integer.parseInt(input[4]);

			map = new int[N][M];
			v = new boolean[N][M];
			v[Y][X] = true;
			answer = 1;
			for (int i = 0; i < N; i++) {
				input = br.readLine().split(" ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}

			Queue<xyt> q = new LinkedList<>();
			q.add(new xyt(X, Y, 0));

			while (!q.isEmpty()) {
				xyt temp = q.poll();

				if (temp.t == TIME - 1) {
					break;
				}

				for (int i = 0; i < 4; i++) { // 0: 우, 1: 하, 2: 좌, 3: 상
					switch (i) {
					case 0:
						if (map[temp.y][temp.x] == 2 || map[temp.y][temp.x] == 6 || map[temp.y][temp.x] == 7) {
							continue;
						}
						break;
					case 1:
						if (map[temp.y][temp.x] == 3 || map[temp.y][temp.x] == 4 || map[temp.y][temp.x] == 7) {
							continue;
						}
						break;
					case 2:
						if (map[temp.y][temp.x] == 2 || map[temp.y][temp.x] == 4 || map[temp.y][temp.x] == 5) {
							continue;
						}
						break;
					case 3:
						if (map[temp.y][temp.x] == 3 || map[temp.y][temp.x] == 5 || map[temp.y][temp.x] == 6) {
							continue;
						}
						break;
					}

					int ny = temp.y + dy[i];
					int nx = temp.x + dx[i];

					if (ny >= 0 && nx >= 0 && nx < M && ny < N && v[ny][nx] == false) {
						if (map[ny][nx] == 0) {
							continue;
						}

						// 0: 좌가 열림, 1 : 상이 열림, 2: 우가 열림, 3: 하가 열림
						switch (i) {
						case 0:
							if (map[ny][nx] == 2 || map[ny][nx] == 4 || map[ny][nx] == 5) {
								continue;
							}
							break;
						case 1:
							if (map[ny][nx] == 3 || map[ny][nx] == 5 || map[ny][nx] == 6) {
								continue;
							}
							break;
						case 2:
							if (map[ny][nx] == 2 || map[ny][nx] == 6 || map[ny][nx] == 7) {
								continue;
							}
							break;
						case 3:
							if (map[ny][nx] == 3 || map[ny][nx] == 4 || map[ny][nx] == 7) {
								continue;
							}
							break;
						}

						v[ny][nx] = true;
						answer++;
						q.add(new xyt(nx, ny, temp.t + 1));
					}
				}
			}

			sb.append("#" + t + " " + answer + "\n");
			
		}

		System.out.println(sb);
	}

}

class xyt {
	int x, y, t;

	public xyt(int x, int y, int t) {
		this.x = x;
		this.y = y;
		this.t = t;
	}
}