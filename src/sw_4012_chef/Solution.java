package sw_4012_chef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	static int N, min;
	static int[][] S = new int[16][16];
	static Stack<Integer> A, B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		A = new Stack<>();
		A.push(0);
		B = new Stack<>();
		String[] input;

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			// 테이블 입력
			for (int i = 0; i < N; i++) {
				input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(input[j]);
				}
			}

			// 합산 시너지 미리 계산
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					S[i][j] += S[j][i];
				}
			}

			// 알고리즘 시작
			search(1, 0, 0);

			sb.append("#" + t + " " + min + "\n");
		}
		System.out.println(sb);
	}

	static void search(int cnt, int senergyA, int senergyB) {
		if (A.size() == N / 2 && B.size() == N / 2) {
			min = Math.min(min, Math.abs(senergyA - senergyB));
			return;
		}
		if (A.size() < N / 2) {
			// 시너지 미리 계산
			int temp = senergyA;
			for (int i = 0; i < A.size(); i++) {
				temp += S[A.get(i)][cnt];
			}
			A.push(cnt);
			search(cnt + 1, temp, senergyB);
			A.pop();
		}
		if (B.size() < N / 2) {
			// 시너지 미리 계산
			int temp = senergyB;
			for (int i = 0; i < B.size(); i++) {
				temp += S[B.get(i)][cnt];
			}
			B.push(cnt);
			search(cnt + 1, senergyA, temp);
			B.pop();
		}
	}
}
