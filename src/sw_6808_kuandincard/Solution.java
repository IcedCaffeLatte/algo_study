package sw_6808_kuandincard;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	static int[] Kcard = new int[9];
	static int[] Icard = new int[9];
	static int win, lose;
	static int[] in;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] input;
		int mainFlag = 0;

		for (int t = 1; t <= T; t++) {
			win = 0;
			lose = 0;
			in = new int[9];
			input = br.readLine().split(" ");
			mainFlag = 0;
			for (int i = 0; i < 9; i++) {
				Kcard[i] = Integer.parseInt(input[i]);
				mainFlag = mainFlag | 1 << Kcard[i];
			}
			int cnt = 0;
			for (int i = 1; i < 19; i++) {
				if ((mainFlag & 1 << i) == 0) {
					Icard[cnt++] = i;
				}
			}

			search(0);

			System.out.println("#" + t + " " + win + " " + lose);
		}
	}

	static void search(int cnt) {
		if (cnt == 9) {
			int a = 0;
			int b = 0;

			for (int i = 0; i < 9; i++) {
				if (in[i] > Kcard[i]) {
					a += in[i] + Kcard[i];
				}
				else if (in[i] < Kcard[i]) {
					b += in[i] + Kcard[i];
				}
			}
			if (a > b) {
				lose++;
			}
			else if (b > a) {
				win++;
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (in[i] == 0) {
				in[i] = Icard[cnt];
				search(cnt + 1);
				in[i] = 0;
			}
		}
	}
}