package boj_2636_cheese;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int cheeseCnt, X, Y, time;;
	static int[][] cheese;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		Y = Integer.parseInt(input[0]);
		X = Integer.parseInt(input[1]);

		cheese = new int[Y][X];
		cheeseCnt = 0;
		int thisTimeCheese = 0;
		time = 0;

		for (int i = 0; i < Y; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < X; j++) {
				cheese[i][j] = Integer.parseInt(input[j]) == 1 ? 0 : 1;
				if (cheese[i][j] == 0) {
					cheeseCnt++;
				}
			}
		}

		// 알고리즘 시작
		while (cheeseCnt > 0) {
			time++;
			thisTimeCheese = cheeseCnt;

			dfs(0, 0);
		}

		System.out.println(time);
		System.out.println(thisTimeCheese);

	}

	static void dfs(int y, int x) {
		for (int i = 0; i < 4; i++) {
			if (x + dx[i] >= 0 && x + dx[i] < X && y + dy[i] >= 0 && y + dy[i] < Y) {
				// 근방에 치즈 발견
				if (cheese[y + dy[i]][x + dx[i]] == 0) {
					cheese[y + dy[i]][x + dx[i]] = time + 1;
					cheeseCnt--;
				}
				// 근방에 빈공간 발견
				else if (cheese[y + dy[i]][x + dx[i]] <= time) {
					cheese[y + dy[i]][x + dx[i]] = time + 1;
					dfs(y + dy[i], x + dx[i]);
				}
			}
		}
	}
}
