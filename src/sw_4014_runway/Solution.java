package sw_4014_runway;

import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int answer = 0;
			input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int X = Integer.parseInt(input[1]);
			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}

			// 가로 먼저 파악하기
			for (int i = 0; i < N; i++) {
				boolean[] used = new boolean[N];
				next: for (int j = 0; j < N; j++) {
					if (j == N - 1) {
						answer++;
						break;
					}
					// 다음 지형이 높을 때
					if (map[i][j] == map[i][j + 1] - 1) {
						if (j - X + 1 < 0) { // 경사로가 맵 밖으로 나간 경우
							break;
						}
						// 경사로 지을 수 있는지 파악
						for (int k = j; k > j - X; k--) {
							if (map[i][k] != map[i][j] || used[k]) {
								break next;
							}
						}
					}
					// 다음 지형이 낮을 때
					else if (map[i][j] == map[i][j + 1] + 1) {
						if (j + X >= N) { // 경사로가 맵 밖으로 나간 경우
							break;
						}
						for (int k = j + 1; k <= j + X; k++) {
							if (map[i][k] != map[i][j + 1]) {
								break next;
							}
							used[k] = true;
						}
					}
					else if (map[i][j] == map[i][j + 1]) {
						continue;
					}
					// 경사 높이가 2이상 차이 날 경우
					else {
						break;
					}
				}
			}

			// 세로
			for (int i = 0; i < N; i++) {
				boolean[] used = new boolean[N];
				next: for (int j = 0; j < N; j++) {
					if (j == N - 1) {
						answer++;
						break;
					}
					// 다음 지형이 높을 때
					if (map[j][i] == map[j + 1][i] - 1) {
						if (j - X + 1< 0) { // 경사로가 맵 밖으로 나간 경우
							break;
						}
						// 경사로 지을 수 있는지 파악
						for (int k = j; k > j - X; k--) {
							if (map[k][i] != map[j][i] || used[k]) {
								break next;
							}
						}
					}
					// 다음 지형이 낮을 때
					else if (map[j][i] == map[j + 1][i] + 1) {
						if (j + X >= N) { // 경사로가 맵 밖으로 나간 경우
							break;
						}
						for (int k = j + 1; k <= j + X; k++) {
							if (map[k][i] != map[j + 1][i]) {
								break next;
							}
							used[k] = true;
						}
					}
					else if (map[j][i] == map[j + 1][i]) {
						continue;
					}
					// 경사 높이가 2이상 차이 날 경우
					else {
						break;
					}
				}
			}
			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}
}