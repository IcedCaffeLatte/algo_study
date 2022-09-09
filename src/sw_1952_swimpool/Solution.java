package sw_1952_swimpool;

import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			input = br.readLine().split(" ");
			int d = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			int tm = Integer.parseInt(input[2]);
			int y = Integer.parseInt(input[3]);

			int[] month = new int[13];

			input = br.readLine().split(" ");
			for (int i = 1; i < 13; i++) {
				month[i] = Integer.parseInt(input[i-1]);
			}
			int[] pay = new int[13];
			pay[1] = Math.min(d * month[1], m);
			for (int i = 2; i < 13; i++) {
				// 하루와 1개월 중 싼거 계산
				pay[i] = pay[i - 1] + Math.min(d * month[i], m);

				// 3개월 계산
				if (i > 2) {
					pay[i] = Math.min(pay[i], pay[i - 3] + tm);
				}
			}

			// 년 계산
			pay[12] = Math.min(pay[12], y);

			sb.append("#" + t + " " + pay[12] + "\n");
		}
		System.out.println(sb);
	}
}
