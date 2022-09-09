package sw_1859_millionaire;

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
			int prePos = 0, max = 0, maxPos = 0;
			long money = 0;
			int[] raw = new int[N];

			input = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				raw[i] = Integer.parseInt(input[i]);
				if (max < raw[i]) {
					max = raw[i];
					maxPos = i;
				}
			}

			while (true) {
				for (int i = prePos; i < maxPos; i++) {
					money += max - raw[i];
				}

				if (maxPos == N - 1) {
					break;
				}
				maxPos++;
				prePos = maxPos;
				max = raw[prePos];
				for (int i = prePos; i < N; i++) {
					if (max < raw[i]) {
						max = raw[i];
						maxPos = i;
					}
				}
			}
			sb.append("#" + t + " " + money + "\n");
		}
		System.out.println(sb);
	}
}
