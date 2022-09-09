package sw_1223_cal2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N, answer, sum;
		String[] plus;
		String[] mod;

		for (int t = 1; t <= 10; t++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			plus = br.readLine().split("\\+");

			for (int i = 0; i < plus.length; i++) {
				mod = plus[i].split("\\*");
				sum = Integer.parseInt(mod[0]);
				for (int j = 1; j < mod.length; j++) {
					sum *= Integer.parseInt(mod[j]);
				}
				answer += sum;
			}
			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}
}
