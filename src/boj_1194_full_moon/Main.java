package boj_1194_full_moon;

// BFS, 3차원 방문체크

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int R = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);
		int[] dy = { 0, 1, -1, 0 };
		int[] dx = { 1, 0, 0, -1 };
		boolean[][][] v = new boolean[R][C][64];

		char[][] map = new char[R][C];
		Queue<node> list = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '0') {
					list.add(new node(j, i, 0, 0));
					v[i][j][0] = true;
				}
			}
		}

         
		while (!list.isEmpty()) {
			node temp = list.poll();
            if (map[temp.y][temp.x] == '1') {
                System.out.println(temp.c);
                return;
            }

			for (int k = 0; k < 4; k++) {
				int ny = temp.y + dy[k];
				int nx = temp.x + dx[k];

				if (ny >= 0 && ny < R && nx >= 0 && nx < C && v[ny][nx][temp.key] == false && map[ny][nx] != '#') {
					// 열쇠
					if (map[ny][nx] >= 'a' && map[ny][nx] <= 'f') {
						if (!v[ny][nx][temp.key | 1 << (map[ny][nx] - 'a')]) {
							v[ny][nx][temp.key | 1 << (map[ny][nx] - 'a')] = true;
							v[ny][nx][temp.key] = true;
							list.add(new node(nx, ny, temp.c + 1, temp.key | 1 << (map[ny][nx] - 'a')));
						}
					}
					// 문
					else if (map[ny][nx] >= 'A' && map[ny][nx] <= 'F') {
						if ((temp.key & (1 << (map[ny][nx] - 'A'))) > 0) {
							v[ny][nx][temp.key] = true;
							list.add(new node(nx, ny, temp.c + 1, temp.key));
						}
					}
					// 빈칸
					else {
						v[ny][nx][temp.key] = true;
						list.add(new node(nx, ny, temp.c + 1, temp.key));
					}
				}
			}
		}
		System.out.println(-1);
	}

	static class node {
		int x, y, c, key;

		public node(int x, int y, int c, int key) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.key = key;
		}
	}
}
