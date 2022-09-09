package sw_1961_numArrSpin;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(input[j]);
				}
			}

			sb.append("#" + t + "\n");
			for (int i = 0; i < N; i++) {
				// 밑에서 올라가는거
				for (int y = N - 1; y >= 0; y--) {
					sb.append(arr[y][i]);
				}
				sb.append(" ");
				
				// 반대에서 오는거
				for (int x = N - 1; x >= 0; x--) {
					sb.append(arr[N - i - 1][x]);
				}
				sb.append(" ");

				// 반대편에서 내려가는거
				for (int y = 0; y < N; y++) {
					sb.append(arr[y][N - i - 1]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
