package boj_10163_colorPaper;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		int maxX = 0, maxY = 0, minX = 1001, minY = 1001;
		int N = Integer.parseInt(br.readLine());
		paper[] paper = new paper[N];
		int area[] = new int[N];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			paper[i] = new paper(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]),
					Integer.parseInt(input[3]));
			if (paper[i].x1 < minX) {
				minX = paper[i].x1;
			}
			if (paper[i].y1 < minY) {
				minY = paper[i].y1;
			}
			if (paper[i].x2 + paper[i].x1 > maxX) {
				maxX = paper[i].x2 + paper[i].x1;
			}
			if (paper[i].y2 + paper[i].y1 > maxY) {
				maxY = paper[i].y2 + paper[i].y1;
			}
		}
		int[][] plane = new int[maxY - minY][maxX - minX];

		for (int i = N - 1; i >= 0; i--) {
			for (int y = paper[i].y1 - minY; y < paper[i].y2 + paper[i].y1 - minY; y++) {
				for (int x = paper[i].x1 - minX; x < paper[i].x2 + paper[i].x1 - minX; x++) {
					if (plane[y][x] == 0) {
						plane[y][x] = i + 1;
						area[i]++;
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(area[i]);
		}
	}

	static class paper {
		int x1, y1, x2, y2;

		public paper(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
}
