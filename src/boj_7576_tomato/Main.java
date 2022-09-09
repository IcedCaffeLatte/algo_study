package boj_7576_tomato;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };
		int[][] map = new int[N][M];
		int time = 0;
		int cnt = N * M;

		Deque<tomato> q = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (map[i][j] == 1) {
					q.offer(new tomato(i, j, 0));
				}
				if (map[i][j] != 0) {
					cnt--;
				}
			}
		}

		// bfs 시작
		while (!q.isEmpty()) {
			tomato temp = q.poll();
			time = temp.c;
			for (int i = 0; i < 4; i++) {
				int ny = temp.y + dy[i];
				int nx = temp.x + dx[i];

				if (ny >= 0 && nx >= 0 && ny < N && nx < M && map[ny][nx] == 0) {
					q.offer(new tomato(ny, nx, temp.c + 1));
					map[ny][nx] = 1;
					cnt--;
				}
			}
		}

		if (cnt > 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(time);
		}
	}

}

class tomato {
	int y, x, c;

	public tomato(int y, int x, int c) {
		this.y = y;
		this.x = x;
		this.c = c;
	}
}