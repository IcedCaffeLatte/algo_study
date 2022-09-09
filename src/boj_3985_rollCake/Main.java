package boj_3985_rollCake;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int L, N, think, real, thinkMax, realMax;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		String[] input;
		int[] rollCake = new int[L + 1];
		audience[] au = new audience[N + 1];

		for (int i = 1; i <= N; i++) {
			int eatCake = 0;
			input = br.readLine().split(" ");
			au[i] = new audience(Integer.parseInt(input[0]), Integer.parseInt(input[1]));

			// 예상으로 가장 많이 가져갈 사람
			if (thinkMax < au[i].K - au[i].P) {
				thinkMax = au[i].K - au[i].P;
				think = i;
			}

			// 실제로 내가 케잌을 가져가는 개수 구하기
			for (int j = au[i].P; j <= au[i].K; j++) {
				// 이미 다른 사람이 선점한 구간 점프
				if (rollCake[j] != 0) {
					j = au[rollCake[j]].K;
				}
				// 다른 사람이 가져간 구간이 아니라면 내꺼
				else {
					rollCake[j] = i;
					eatCake++;
				}
			}

			// 실제로 많이 가져간 사람
			if (realMax < eatCake) {
				realMax = eatCake;
				real = i;
			}
		}

		System.out.println(think);
		System.out.println(real);
	}

	static class audience {
		int P, K;

		public audience(int p, int k) {
			P = p;
			K = k;
		}
	}
}
