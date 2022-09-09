package boj_2458_OhMyHeight;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 99999999;
			}
		}

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			map[Integer.parseInt(input[0]) - 1][Integer.parseInt(input[1]) - 1] = 1;
		}

		for (int k = 0; k < N; k++) { // 경유지
			for (int i = 0; i < N; i++) { // 출발지
				for (int j = 0; j < N; j++) { // 도착지
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 99999999 || map[j][i] != 99999999) {
					cnt++;
				}
			}
			if (cnt == N - 1) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}
