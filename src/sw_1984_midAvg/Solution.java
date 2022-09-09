package sw_1984_midAvg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			double answer = 0;
			int min = 10000, max = 0, temp;
			input = br.readLine().split(" ");

			for (int i = 0; i < 10; i++) {
				temp = Integer.parseInt(input[i]);
				// 최소
				if (min > temp) {
					min = temp;
				}
				// 최대
				if (max < temp) {
					max = temp;
				}
				// 더하기
				answer += temp;
			}
			// 평균구하기
			answer = (double) (answer - max - min) / 8;

			sb.append("#" + t + " " + Math.round(answer) + "\n");
		}
		System.out.println(sb);
	}
}
