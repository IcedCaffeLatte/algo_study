package boj_2239_sudoku;

import java.io.*;
import java.util.ArrayList;

public class Main {
	static int[][] sudoku = new int[9][9];
	static int unknown;

	static ArrayList<xy> blank = new ArrayList<xy>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		unknown = 0;

		for (int i = 0; i < 9; i++) {
			input = br.readLine();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = input.charAt(j) - '0';
				if (sudoku[i][j] == 0) {
					unknown++;
					blank.add(new xy(j, i));
				}
			}
		}

		dfs(0);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(sudoku[i][j]);
			}
			System.out.println();
		}
	}

	public static void dfs(int pos) {
		if (pos == blank.size() || unknown == 0) {
			return;
		}
		xy xy = blank.get(pos);
		boolean[] v = new boolean[10];

		// 세로 확인
		for (int i = 0; i < 9; i++) {
			v[sudoku[i][xy.x]] = true;
		}
		// 가로
		for (int i = 0; i < 9; i++) {
			v[sudoku[xy.y][i]] = true;
		}
		// 3x3 확인
		for (int i = 3 * (xy.y / 3); i < 3 * ((xy.y / 3) + 1); i++) {
			for (int j = 3 * (xy.x / 3); j < 3 * ((xy.x / 3) + 1); j++) {
				v[sudoku[i][j]] = true;
			}
		}

		for (int i = 1; i < 10; i++) {
			if (v[i] == false) {
				sudoku[xy.y][xy.x] = i;
				unknown--;
				dfs(pos + 1);
				if (unknown == 0) {
					return;
				}
				sudoku[xy.y][xy.x] = 0;
				unknown++;
			}
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
