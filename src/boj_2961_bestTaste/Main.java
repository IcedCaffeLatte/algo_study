package boj_2961_bestTaste;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][] taste;
	static int min = 1000000000;
	static int N;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		String[] input;

		taste = new int[N][2];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			taste[i][0] = Integer.parseInt(input[0]);
			taste[i][1] = Integer.parseInt(input[1]);
		}

		search(0, 1, 0);
		
		System.out.println(min);
	}

	static void search(int pos, int s, int b) {
		
		// 탈출조건
		if (pos == N) {
			int temp = s - b;
			if (temp < 0) {
				temp = -temp;
			}
			if (temp < min && b != 0) {
				min = temp;
			}
			return;
		}
		
		// 다음거 탐색 조건
		search(pos + 1, s, b);
		search(pos + 1, s * taste[pos][0], b + taste[pos][1]);
	}
}
