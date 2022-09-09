package boj_17070_moving_pipe;

// DP

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		int N = Integer.parseInt(br.readLine().trim());

		int[][] map = new int[N][N];
		// 해당 위치에 가로로 들어온 파이프 수
		int[][] garo = new int[N][N];
		// 해당 위치에 세로로 들어온 파이프 수
		int[][] sero = new int[N][N];
		// 해당 위치에 대각선으로 들어온 파이프 수
		int[][] degak = new int[N][N];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (map[i][j] == 1) {
					map[i][j] = -1;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			if (map[0][i] == -1) {
				break;
			}
			garo[0][i] = 1;
		}

		for (int i = 1; i < N; i++) {
			for (int j = 2; j < N; j++) {
				// -1이면 통과
				if (map[i][j] == -1) {
					continue;
				}
				// 대각선 위 확인
				if (map[i - 1][j - 1] != -1 && map[i - 1][j] != -1 && map[i][j - 1] != -1) {
					degak[i][j] += degak[i - 1][j - 1] + sero[i - 1][j - 1] + garo[i - 1][j - 1];
				}
				// 세로 확인
				if (map[i - 1][j] != -1) {
					sero[i][j] += degak[i - 1][j] + sero[i - 1][j];
				}
				// 가로 확인
				if (map[i][j - 1] != -1) {
					garo[i][j] += degak[i][j - 1] + garo[i][j - 1];
				}
			}
		}
		
		// 해당위치로 들어오는 모든 파이프 수를 풀력
		System.out.println(degak[N - 1][N - 1] + sero[N - 1][N - 1] + garo[N - 1][N - 1]);
	}
}
