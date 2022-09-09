package sw_1979_whereWord;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int answer = 0;
			input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int K = Integer.parseInt(input[1]);
			int leng = 0;
			int[][] arr = new int[N][N];
			
			//가로 낱말 + arr에 데이터 저장하기
			for (int i = 0; i < N; i++) {
				input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(input[j]);
					if (arr[i][j] == 1) {
						leng++;
					}
					else if (arr[i][j] == 0 && leng == K) {
						answer++;
					}
					if(arr[i][j] == 0) {
						leng=0;
					}
				}
				if (leng == K) {
					answer++;
				}
				leng = 0;
			}
			// 세로 낱말
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[j][i] == 1) {
						leng++;
					}
					else if (arr[j][i] == 0 && leng == K) {
						answer++;
					}
					if (arr[j][i] == 0) {
						leng = 0;
					}
				}
				if (leng == K) {
					answer++;
				}
				leng = 0;
			}
			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}
}
