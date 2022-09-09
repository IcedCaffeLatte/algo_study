package boj_1261_algoSpot;

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
		int wall = 1;

		Queue<xyc> q = new LinkedList<>();
		Queue<xyc> wallQ = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String inputS = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = inputS.charAt(j) - 48;
				if (map[i][j] == 1) {
					map[i][j] = -1;
				}
			}
		}
		
		boolean[][] v = new boolean[N][M];
		v[0][0] = true;
		q.offer(new xyc(0, 0, wall));

		while (v[N - 1][M - 1] == false) {
			// 근방에서 벽 찾기
			while (!q.isEmpty()) {
				xyc temp = q.poll();
				wall = temp.c;
				for (int i = 0; i < 4; i++) {
					int ny = temp.y + dy[i];
					int nx = temp.x + dx[i];

					if (ny >= 0 && nx >= 0 && ny < N && nx < M && !v[ny][nx]) {
						// 일반적인 bfs
						if (map[ny][nx] == 0) {
							v[ny][nx] = true;
							q.offer(new xyc(ny, nx, temp.c));
						}
						// 벽을 부수기 위한 대기열 wallQ에 추가
						else if (map[ny][nx] == -1) {
							v[ny][nx] = true;
							wallQ.offer(new xyc(ny, nx, temp.c + 1));
						}
					}
				}
			}
			
			// 벽부터 다시 찾기 위해 wallQ의 데이터를 q에 추가 하면서
			// 벽 뿌시기
			while (!wallQ.isEmpty()) {
				xyc temp = wallQ.poll();
				q.offer(temp);

				map[temp.y][temp.x] = 0;
			}
		}

		System.out.println(wall - 1);
	}
}

class xyc {
	int y, x, c;

	public xyc(int y, int x, int c) {
		this.y = y;
		this.x = x;
		this.c = c;
	}
}