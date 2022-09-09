package boj_2567_colorpaper2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		int x, y;
		int[][] colorPaper;
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };
		int answer = 0;
		String[] input;
		colorPaper = new int[101][101];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			x = Integer.parseInt(input[0]);
			y = Integer.parseInt(input[1]);
			for (int X = x; X < x + 10; X++) {
				for (int Y = y; Y < y + 10; Y++) {
					colorPaper[Y][X] = 1;
				}
			}
		}

		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (colorPaper[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int nx = j + dx[k];
						int ny = i + dy[k];
						if (colorPaper[ny][nx] == 0) {
							answer++;
						}
					}
				}
			}
		}

		System.out.println(answer);
	}
}