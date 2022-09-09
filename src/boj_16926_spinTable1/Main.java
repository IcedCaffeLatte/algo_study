package boj_16926_spinTable1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int L = Integer.parseInt(input[2]);

		int[][] array = new int[N][M];
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(input[j]);
			}
		}

		for (int i = 0; i < N / 2 && i < M / 2; i++) {
			Queue<Integer> q = new LinkedList<>();

			// 가로
			for (int j = i; j < M - i - 1; j++) {
				q.add(array[i][j]);
			}
			// 세로
			for (int j = i; j < N - i - 1; j++) {
				q.add(array[j][M - i - 1]);
			}
			// 가로 역방향
			for (int j = M - i - 1; j > i; j--) {
				q.add(array[N - i - 1][j]);
			}
			// 세로 역방향
			for (int j = N - i - 1; j > i; j--) {
				q.add(array[j][i]);
			}

			// 순서 바꾸기
			for (int j = 0; j < L; j++) {
				q.add(q.poll());
			}
			
			// 집어 넣기
			for (int j = i; j < M - i - 1; j++) {
				array[i][j] = q.poll();
			}
			for (int j = i; j < N - i - 1; j++) {
				array[j][M - i - 1] = q.poll();
			}
			for (int j = M - i - 1; j > i; j--) {
				array[N - i - 1][j] = q.poll();
			}
			for (int j = N - i - 1; j > i; j--) {
				array[j][i] = q.poll();
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
