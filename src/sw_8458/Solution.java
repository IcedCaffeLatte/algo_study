package sw_8458;

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
			int[] len = new int[N];
			int sum = 0;
			int cnt = 0;
			
			input = br.readLine().split(" ");
			len[0] = Math.abs(Integer.parseInt(input[0])) + Math.abs(Integer.parseInt(input[1]));
			int max = len[0];
			
			for (int i = 1; i < N; i++) {
				input = br.readLine().split(" ");
				len[i] = Math.abs(Integer.parseInt(input[0])) + Math.abs(Integer.parseInt(input[1]));
				max = Math.max(max, len[i]);
				if (len[i] % 2 != len[i - 1] % 2) {
					cnt = -1;
				}
			}

			if (cnt == 0) {
				while (true) {
					if (sum >= max && (max - sum) % 2 == 0) {
						break;
					}
					sum += ++cnt;
				}
			}
			
			sb.append("#" + t + " " + cnt + "\n");

		}
		
		System.out.println(sb);
	}
}