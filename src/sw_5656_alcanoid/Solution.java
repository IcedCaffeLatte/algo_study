package sw_5656_alcanoid;

import java.io.*;

/**
 * 원본 코드
 * 
 * @author THKim file: Solution_5656_벽돌깨기_DFS.java
 */

public class Solution {

	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static int N, W, H, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			W = Integer.parseInt(input[1]);
			H = Integer.parseInt(input[2]);

			int[][] map = new int[H][W];

			for (int i = 0; i < H; i++) {
				input = br.readLine().split(" ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}

			min = Integer.MAX_VALUE;
			go(0, map);
			System.out.println("#" + t + " " + min);
		}
	}

	private static void go(int cnt, int[][] map) {
		if (cnt == N) {
			int result = getRemain(map);
			min = Math.min(result, min);
			return;
		}

		int[][] newMap = new int[H][W];
		for (int c = 0; c < W; c++) {

			int r = 0;
			while (r < H && map[r][c] == 0) {
				r++;
			}

			if (r == H) {
				go(cnt + 1, map);
			}
			else {
				copy(map, newMap);
				boom(newMap, r, c, newMap[r][c]);
				down(newMap);
				go(cnt + 1, newMap);
			}
		}
	}

	private static int getRemain(int[][] map) {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] > 0) {
					count++;
				}
			}
		}
		return count;
	}

	// down 은 직접 쓴 코드
	private static void down(int[][] map) {
		for (int c = 0; c < W; c++) {
			int i = H - 1;
			int j = H - 2;
			while (j >= 0) {
				if (map[i][c] == 0) {
					if (map[j][c] > 0) {
						map[i][c] = map[j][c];
						map[j][c] = 0;
						i--;
					}
				}
				else {
					i--;
				}
				j--;
			}
		}
	}

	private static void boom(int[][] map, int r, int c, int cnt) {
		map[r][c] = 0;
		if (cnt == 1) {
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r;
			int nc = c;
			for (int k = 1; k < cnt; k++) {
				nr += dr[d];
				nc += dc[d];
				if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 0) {
					boom(map, nr, nc, map[nr][nc]);
				}
			}
		}
	}

	private static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}
}