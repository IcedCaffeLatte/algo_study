package sw_5643_heightLine;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input;
		int T = Integer.parseInt(br.readLine().trim());
		int N, M, answer;
		int[][] map;

		for (int t = 1; t <= T; t++) {
			answer = 0;
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];

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
			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}
}
