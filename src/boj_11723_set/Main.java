package boj_11723_set;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input;

		int N = Integer.parseInt(br.readLine());
		int S = 0;
		int num;

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");

			switch (input[0]) {
			case "add":
				num = Integer.parseInt(input[1]);
				S = S | 1 << num;
				break;
			case "remove":
				num = Integer.parseInt(input[1]);
				if ((S & 1 << num) > 0) {
					S -= 1 << num;
				}
				break;
			case "check":
				num = Integer.parseInt(input[1]);
				sb.append(((S & 1 << num) > 0 ? 1 : 0) + "\n");
				break;
			case "toggle":
				num = Integer.parseInt(input[1]);
				if ((S & 1 << num) > 0) {
					S -= 1 << num;
				}
				else {
					S = S | 1 << num;
				}
				break;
			case "all":
				S = -1;
				break;
			case "empty":
				S = 0;
				break;
			}
		}
		System.out.println(sb);
	}
}
