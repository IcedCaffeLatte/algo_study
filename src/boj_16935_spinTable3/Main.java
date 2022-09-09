package boj_16935_spinTable3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int R = Integer.parseInt(input[2]);
		int temp;

		int[][] array = new int[N][M];
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(input[j]);
			}
		}
		input = br.readLine().split(" ");

		for (int r = 0; r < R; r++) {
			switch (input[r]) {
			case "1":
				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < M; j++) {
						temp = array[i][j];
						array[i][j] = array[N - 1 - i][j];
						array[N - 1 - i][j] = temp;
					}
				}
				break;
			case "2":
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M / 2; j++) {
						temp = array[i][j];
						array[i][j] = array[i][M - 1 - j];
						array[i][M - 1 - j] = temp;
					}
				}
				break;
			case "3":
				int[][] tempArray = new int[M][N];
				for (int i = 0; i < M; i++) {
					for (int j = 0; j < N; j++) {
						tempArray[i][j] = array[N - j - 1][i];
					}
				}
				array = tempArray;
				temp = M;
				M = N;
				N = temp;
				break;
			case "4":
				int[][] tempArray2 = new int[M][N];
				for (int i = 0; i < M; i++) {
					for (int j = 0; j < N; j++) {
						tempArray2[i][j] = array[j][M - 1 - i];
					}
				}
				array = tempArray2;
				temp = M;
				M = N;
				N = temp;
				break;
			case "5":
				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < M / 2; j++) {
						temp = array[i][j];
						array[i][j] = array[N / 2 + i][j];
						array[N / 2 + i][j] = array[N / 2 + i][M / 2 + j];
						array[N / 2 + i][M / 2 + j] = array[i][M / 2 + j];
						array[i][M / 2 + j] = temp;
					}
				}
				break;
			case "6":
				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < M / 2; j++) {
						temp = array[i][j];
						array[i][j] = array[i][M / 2 + j];
						array[i][M / 2 + j] = array[N / 2 + i][M / 2 + j];
						array[N / 2 + i][M / 2 + j] = array[N / 2 + i][j];
						array[N / 2 + i][j] = temp;
					}
				}
				break;
			default:
				break;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(array[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
