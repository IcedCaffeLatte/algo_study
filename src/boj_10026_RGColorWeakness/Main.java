package boj_10026_RGColorWeakness;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[][] grid;
	static int N;
	static boolean[][] visited, visited2;
	static int[] dy = { 0, 1, 0, -1 }, dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		N = Integer.parseInt(br.readLine());
		grid = new char[N][N];
		visited = new boolean[N][N];
		visited2 = new boolean[N][N];
		int normal = 0, weakness = 0;

		for (int i = 0; i < N; i++) {
			input = br.readLine();
			for (int j = 0; j < N; j++) {
				grid[i][j] = input.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false) {
					dfs(i, j);
					normal++;
				}
				if (visited2[i][j] == false) {
					dfsweak(i, j);
					weakness++;
				}
			}
		}
		System.out.println(normal + " " + weakness);
	}

	static void dfs(int y, int x) {
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			if (y + dy[i] >= 0 && x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] < N
					&& visited[y + dy[i]][x + dx[i]] == false && grid[y][x] == grid[y + dy[i]][x + dx[i]]) {
				dfs(y + dy[i], x + dx[i]);
			}
		}
	}

	static void dfsweak(int y, int x) {
		visited2[y][x] = true;
		for (int i = 0; i < 4; i++) {
			if (y + dy[i] >= 0 && x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] < N
					&& visited2[y + dy[i]][x + dx[i]] == false) {
				char temp = grid[y][x] == 'R' ? 'G' : grid[y][x];
				char temp2 = grid[y + dy[i]][x + dx[i]] == 'R' ? 'G' : grid[y + dy[i]][x + dx[i]];
				if (temp == temp2) {
					dfsweak(y + dy[i], x + dx[i]);
				}
			}
		}
	}
}
