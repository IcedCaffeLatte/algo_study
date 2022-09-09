package boj_17406;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int K = Integer.parseInt(input[2]);

		int[][] array = new int[N][M];
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(input[j]);
			}
		}

		for (int k = 0; k < K; k++) {
			input = br.readLine().split(" ");
			int r = Integer.parseInt(input[0]) - 1;
			int c = Integer.parseInt(input[1]) - 1;
			int s = Integer.parseInt(input[2]);
			
			//돌리기
			for (int spin = 1; spin <= s ; spin++) {
				for (int x = c - spin ; x < c + spin + 1; x++) {
					
				}
			}
		}
	}
}
