package boj_1987_alphabet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static boolean[] alphabet = new boolean[26];
	static char[][] map;
	static int R, C;
	static int max = 0;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		String temp;
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			temp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
			}
		}

		search(0, 0, 0);

		System.out.println(max);
	}

	public static void search(int y, int x, int cnt) {
		if (alphabet[map[y][x] - 65] == true) {
			max = Math.max(max, cnt);
			return;
		}
		alphabet[map[y][x] - 65] = true;
		for (int i = 0; i < 4; i++) {
			if (y + dy[i] >= 0 && y + dy[i] < R && x + dx[i] >= 0 && x + dx[i] < C) {
				search(y + dy[i], x + dx[i], cnt + 1);
			}
		}
		alphabet[map[y][x] - 65] = false;
	}
}
