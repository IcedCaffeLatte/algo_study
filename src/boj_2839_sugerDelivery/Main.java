package boj_2839_sugerDelivery;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int answer = 0;

		while (true) {
			if (N % 5 == 0) {
				answer += N / 5;
				break;
			}
			else {
				N -= 3;
				answer++;
			}
			if (N < 0) {
				answer = -1;
				break;
			}
		}

		System.out.println(answer);
	}
}
