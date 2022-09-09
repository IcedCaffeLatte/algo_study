package boj_1149_RGB_Street;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		int N = Integer.parseInt(br.readLine());

		int house[][] = new int[N + 1][3];
		int price[][] = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				house[i][j] = Integer.parseInt(input[j]);
			}
		}

		// 알고리즘 시작
		for (int i = 1; i <= N; i++) {
			price[i][0] = Math.min(price[i - 1][1], price[i - 1][2]) + house[i][0];
			price[i][1] = Math.min(price[i - 1][0], price[i - 1][2]) + house[i][1];
			price[i][2] = Math.min(price[i - 1][0], price[i - 1][1]) + house[i][2];
		}
		System.out.println(Math.min(Math.min(price[N][0], price[N][1]), price[N][2]));

	}
}
