package boj_13300_roomAssignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int full = Integer.parseInt(input[1]);

		int S, C, answer = 0;

		int[][] student = new int[6][2];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			S = Integer.parseInt(input[0]);
			C = Integer.parseInt(input[1]) - 1;

			student[C][S]++;
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				answer += student[i][j] / full;
				if (student[i][j] % full > 0) {
					answer++;
				}
			}
		}

		System.out.println(answer);
	}
}
