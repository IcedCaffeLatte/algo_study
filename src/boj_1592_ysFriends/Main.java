package boj_1592_ysFriends;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int L = Integer.parseInt(input[2]);
		int cnt = 0;
		int pos = 0;

		int[] player = new int[N];

		while (true) {
			player[pos]++;
			
			if (player[pos] == M) {
				break;
			}
			
			cnt++;

			if (player[pos] % 2 == 0) {
				pos = (pos - L) % N;
				if (pos < 0) {
					pos += N;
				}
			}
			else {
				pos = (pos + L) % N;
			}
		}
		System.out.println(cnt);
	}
}
