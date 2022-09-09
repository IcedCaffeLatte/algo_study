package boj_3040_snowwhite;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] nanjaeng;
	static int flag = 0;
	static boolean terminate = false;
	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		nanjaeng = new int[9];

		for (int i = 0; i < 9; i++) {
			nanjaeng[i] = Integer.parseInt(br.readLine());
		}

		search(0, 0, 0);
		
		System.out.println(sb);
	}

	static void search(int pos, int cnt, int sum) {
		if (cnt == 7) {
			if (sum != 100) {
				return;
			}
			for (int i = 0; i < 9; i++) {
				if ((flag & 1 << i) > 0) {
					sb.append(nanjaeng[i]+"\n");
				}
			}
			terminate = false;
		}

		if (sum > 100 || pos == 9 || terminate == true) {
			return;
		}

		flag += 1 << pos;
		search(pos + 1, cnt + 1, sum + nanjaeng[pos]);
		flag -= 1 << pos;
		search(pos + 1, cnt, sum);
	}
}