package boj_1992_quadTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][] video;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String input;
		video = new int[N][N];

		for (int i = 0; i < N; i++) {
			input = br.readLine();
			for (int j = 0; j < N; j++) {
				video[i][j] = input.charAt(j) - 48;
			}
		}
		quadTree(0, 0, N);

		System.out.println(sb);

	}

	static void quadTree(int X, int Y, int range) {
		if (range == 1) {
			sb.append(video[Y][X]);
			return;
		}
		// 일단 여기가 다 같은지 확인
		boolean isDiff = false;
		for (int i = Y; i < Y + range; i++) {
			for (int j = X; j < X + range; j++) {
				if (video[Y][X] != video[i][j]) {
					isDiff = true;
					break;
				}
			}
			if (isDiff == true) {
				break;
			}
		}

		// 다르지 않다면
		if (isDiff == false) {
			sb.append(video[Y][X]);
		}
		else {
			sb.append("(");
			quadTree(X, Y, range / 2);
			quadTree(X + range / 2, Y, range / 2);
			quadTree(X, Y + range / 2, range / 2);
			quadTree(X + range / 2, Y + range / 2, range / 2);
			sb.append(")");
		}
	}
}
