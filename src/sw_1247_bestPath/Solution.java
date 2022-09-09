package sw_1247_bestPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int N, distance;
	static xy[] customer;
	static xy start, finish;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		String[] input;

		for (int t = 1; t <= T; t++) {
			// 입력받는 구문
			N = Integer.parseInt(br.readLine());
			customer = new xy[N];
			visited = new boolean[N];
			input = br.readLine().split(" ");
			start = new xy(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
			finish = new xy(Integer.parseInt(input[2]), Integer.parseInt(input[3]));
			for (int i = 0; i < N; i++) {
				customer[i] = new xy(Integer.parseInt(input[2 * i + 4]), Integer.parseInt(input[2 * i + 5]));
			}
			distance = Integer.MAX_VALUE;
			// 입력받는 구문 끝

			search(0, start, 0);

			sb.append("#" + t + " " + distance + "\n");
		}
		System.out.println(sb);
	}

	static void search(int cnt, xy pos, int sum) {
		if (sum >= distance) {
			return;
		}

		if (cnt == N) {
			sum += Math.abs(pos.x - finish.x) + Math.abs(pos.y - finish.y);
			distance = Math.min(distance, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			search(cnt + 1, customer[i], sum + Math.abs(pos.x - customer[i].x) + Math.abs(pos.y - customer[i].y));
			visited[i] = false;
		}
	}

	static class xy {
		int x, y;

		public xy(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
