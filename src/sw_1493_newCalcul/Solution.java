package sw_1493_newCalcul;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		String[] input;
		xy p, q;
		for (int t = 1; t <= T; t++) {
			input = br.readLine().split(" ");
			p = and(Integer.parseInt(input[0]));
			q = and(Integer.parseInt(input[1]));

			sb.append("#" + t + " " + shap(p.x + q.x, p.y + q.y) + "\n");
		}
		System.out.println(sb);
	}

	static xy and(int n) {
		int cnt = 1;
		while (n > 0) {
			n -= cnt;
			cnt++;
		}

		return new xy(cnt + n - 1, -n + 1);
	}

	static int shap(int x, int y) {
		return (((x + y - 1) * (x + y)) / 2) - y + 1;
	}

	static class xy {
		int x, y;

		public xy(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
