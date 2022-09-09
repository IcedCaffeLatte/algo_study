package jo_1733_fiveTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		int win = 0;
		int x = 0, y = 0;

		// 오목판 만들기
		int[][] omok = new int[19][19];
		for (int i = 0; i < 19; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < 19; j++) {
				omok[i][j] = Integer.parseInt(input[j]);
			}
		}

		// 판단하기
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				// 0이면 판단할 필요 없으니 패스
				if (omok[i][j] == 0) {
					continue;
				}
				// 대각선 아래
				if (i < 15 && j < 15 && !(i - 1 >= 0 && j - 1 >= 0 && omok[i][j] == omok[i - 1][j - 1])) {
					for (int k = 1; k < 5; k++) {
						if (omok[i][j] != omok[i + k][j + k]) {
							break;
						}
						// 육목위치 파악
						if (k == 4
								&& (j + k + 1 >= 19 || i + k + 1 >= 19 || omok[i][j] != omok[i + k + 1][j + k + 1])) {
							win = omok[i][j];
							x = j;
							y = i;
							break;
						}
					}
					// 승패 결정나면 그만
					if (win != 0) {
						break;
					}
				}
				// 가로
				if (j < 15 && !(j - 1 >= 0 && omok[i][j] == omok[i][j - 1])) {
					for (int k = 1; k < 5; k++) {
						if (omok[i][j] != omok[i][j + k]) {
							break;
						}
						// 육목위치 파악
						if (k == 4 && (j + k + 1 >= 19 || omok[i][j] != omok[i][j + k + 1])) {
							win = omok[i][j];
							x = j;
							y = i;
							break;
						}
					}
					// 승패 결정나면 그만
					if (win != 0) {
						break;
					}
				}
				// 아래
				if (i < 15 && !(i - 1 >= 0 && omok[i][j] == omok[i - 1][j])) {
					for (int k = 1; k < 5; k++) {
						if (omok[i][j] != omok[i + k][j]) {
							break;
						}
						// 육목위치 파악
						if (k == 4 && (i + k + 1 >= 19 || omok[i][j] != omok[i + k + 1][j])) {
							win = omok[i][j];
							x = j;
							y = i;
							break;
						}
					}
					// 승패 결정나면 그만
					if (win != 0) {
						break;
					}
				}
				// 대각선 위
				if (i > 3 && j < 15 && !(i + 1 < 19 && j - 1 >= 0 && omok[i][j] == omok[i + 1][j - 1])) {
					for (int k = 1; k < 5; k++) {
						if (omok[i][j] != omok[i - k][j + k]) {
							break;
						}
						// 육목위치 파악
						if (k == 4 && (i - k - 1 < 0 || j + k + 1 >= 19 || omok[i][j] != omok[i - k - 1][j + k + 1])) {
							win = omok[i][j];
							x = j;
							y = i;
							break;
						}
					}
					// 승패 결정나면 그만
					if (win != 0) {
						break;
					}
				}
			}
			if (win != 0) {
				break;
			}
		}

		System.out.println(win);
		if (win != 0) {
			System.out.println((y + 1) + " " + (x + 1));
		}
	}
}
