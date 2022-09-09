package boj_4963;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] dx = { 0, 0, 1, -1, 1, 1, -1, -1 };
	static int[] dy = { 1, -1, 0, 0, -1, 1, -1, 1 };
	static int[][] sea;
	static boolean[][] visited;
	static int x, y, total;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		while (true) {
			// 초기화 구문
			input = br.readLine().split(" ");
			x = Integer.parseInt(input[0]);
			y = Integer.parseInt(input[1]);
			sea = new int[y][x];
			visited = new boolean[y][x];
			total = 0;

			// 탈출구문
			if (x == 0 & y == 0) {
				break;
			}

			for (int i = 0; i < y; i++) {
				input = br.readLine().split(" ");
				for (int j = 0; j < x; j++) {
					sea[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			//세는 구문
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					if (visited[i][j] == false && sea[i][j] == 1) {
						total++;
						dfs(i, j);
					}
				}
			}

			System.out.println(total);
		}
	}

	// 방문처리
	static void dfs(int Y, int X) {

		visited[Y][X] = true;
		for (int i = 0; i < 8; i++) {
			if (X + dx[i] < 0 || Y + dy[i] < 0 || X + dx[i] == x || Y + dy[i] == y) {
				continue;
			}
			if (sea[Y + dy[i]][X + dx[i]] == 1 && visited[Y + dy[i]][X + dx[i]] == false) {
				dfs(Y + dy[i], X + dx[i]);
			}
		}
	}
}
