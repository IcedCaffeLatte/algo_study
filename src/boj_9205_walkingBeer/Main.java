package boj_9205_walkingBeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		String[] input;

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			spot[] convi = new spot[N + 2];
			for (int i = 0; i < N + 2; i++) {
				input = br.readLine().split(" ");
				convi[i] = new spot(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
			}

			boolean[][] v = new boolean[N + 2][N + 2];

			for (int i = 0; i < N + 2; i++) {
				for (int j = i + 1; j < N + 2; j++) {
					if (Math.abs(convi[i].x - convi[j].x) + Math.abs(convi[i].y - convi[j].y) <= 1000) {
						v[i][j] = v[j][i] = true;
					}
				}
			}

			for (int k = 0; k < N + 2; k++) {
				for (int i = 0; i < N + 2; i++) {
					for (int j = 0; j < N + 2; j++) {
						if (v[i][k] && v[k][j]) {
							v[i][j] = true;
						}
					}
				}
			}

			System.out.println(v[0][N + 1] ? "happy" : "sad");
		}
	}

	static class spot {
		int y;
		int x;

		public spot(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
