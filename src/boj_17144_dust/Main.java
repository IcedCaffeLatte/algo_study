package boj_17144_dust;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int R = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);
		int T = Integer.parseInt(input[2]);

		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };
		int[][] map = new int[R][C];
		int air1 = 0;
		int air2 = 0;
		int sum = 0;

		for (int i = 0; i < R; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		// 공기청정기 찾기
		for (int i = 0; i < R; i++) {
			if (map[i][0] == -1) {
				air1 = i;
				air2 = i + 1;
				break;
			}
		}

		for (int t = 0; t < T; t++) {
			// 먼지 퍼지기
			int[][] tempMap = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] > 0) {
						int tempNum = map[i][j];
						if (i - 1 >= 0 && map[i - 1][j] != -1) {
							tempNum -= map[i][j] / 5;
							tempMap[i - 1][j] += map[i][j] / 5;
						}
						if (i + 1 < R && map[i + 1][j] != -1) {
							tempNum -= map[i][j] / 5;
							tempMap[i + 1][j] += map[i][j] / 5;
						}
						if (j + 1 < C && map[i][j + 1] != -1) {
							tempNum -= map[i][j] / 5;
							tempMap[i][j + 1] += map[i][j] / 5;
						}
						if (j - 1 >= 0 && map[i][j - 1] != -1) {
							tempNum -= map[i][j] / 5;
							tempMap[i][j - 1] += map[i][j] / 5;
						}
						tempMap[i][j] += tempNum;
					}
				}
			}
			map = tempMap;

			// 공기청정기 가동
			// 위에꺼 먼저
			// 위로
			for (int i = air1 - 2; i >= 0; i--) {
				map[i + 1][0] = map[i][0];
			}
			// 오른쪽으로
			for (int i = 1; i < C; i++) {
				map[0][i - 1] = map[0][i];
			}
			// 아래로
			for (int i = 1; i <= air1; i++) {
				map[i - 1][C - 1] = map[i][C - 1];
			}
			// 왼쪽으로
			for (int i = C - 2; i >= 0; i--) {
				map[air1][i + 1] = map[air1][i];
			}
			// 밑에꺼
			// 아래로
			for (int i = air2 + 2; i < R; i++) {
				map[i - 1][0] = map[i][0];
			}
			// 오른쪽으로
			for (int i = 1; i < C; i++) {
				map[R - 1][i - 1] = map[R - 1][i];
			}
			// 위로
			for (int i = R - 2; i >= air2; i--) {
				map[i + 1][C - 1] = map[i][C - 1];
			}
			// 왼쪽으로
			for (int i = C - 2; i >= 0; i--) {
				map[air2][i + 1] = map[air2][i];
			}

			map[air1][0] = -1;
			map[air1 + 1][0] = -1;
		}

		// 더하기 전에 공기청정기 치우기
		map[air1][0] = 0;
		map[air1 + 1][0] = 0;

		// 다 더하기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum += map[i][j];
			}
		}

		System.out.println(sum);
	}
}