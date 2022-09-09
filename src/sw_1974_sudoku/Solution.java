package sw_1974_sudoku;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	static int[][] sudoku = new int[9][9];
	static int answer = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		String[] input;

		for (int t = 1; t <= T; t++) {
			answer = 1;
			for (int i = 0; i < 9; i++) {
				input = br.readLine().split(" ");
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			search();

			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}

	static void search() {
		for (int i = 0; i < 9; i++) {
			boolean[] row = new boolean[10]; // 가로
			boolean[] cal = new boolean[10]; // 세로
			boolean[] three = new boolean[10]; // 3x3
			for (int j = 0; j < 9; j++) {
				if (row[sudoku[i][j]] == false && cal[sudoku[j][i]] == false
						&& three[sudoku[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3]] == false) {
					row[sudoku[i][j]] = true;
					cal[sudoku[j][i]] = true;
					three[sudoku[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3]] = true;
				}
				else {
					answer = 0;
					return;
				}
			}
		}
	}
}
