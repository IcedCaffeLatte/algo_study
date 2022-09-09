package sw_1490_RCcar;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		String[] input;
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int speed = 0;
			int distance = 0;

			for (int i = 0; i < N; i++) {
				input = br.readLine().split(" ");
				if (input[0].equals("1")) {
					speed += Integer.parseInt(input[1]);
				}
				else if (input[0].equals("2")) {
					speed -= Integer.parseInt(input[1]);

					if (speed < 0) {
						speed = 0;
					}
				}
				
				distance += speed;
				
			}
			sb.append("#" + t + " " + distance + "\n");

		}
		System.out.println(sb);
	}
}