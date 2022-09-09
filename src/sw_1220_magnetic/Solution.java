package sw_1220_magnetic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input;
		int answer,N;

		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			ArrayList<Integer>[] field = new ArrayList[N];
			answer = 0;
			
			for (int i = 0; i < N; i++) {
				field[i] = new ArrayList<>();
			}
			for (int i = 0; i < N; i++) {
				input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					if (!input[j].equals("0")) {
						field[j].add(Integer.parseInt(input[j]));
					}
				}
			}
			
			//1이 N극 2가 S극
			for (int i = 0; i < N; i++) {
				int temp = 0;
				for (int j = 0; j< field[i].size(); j++) {
					if (field[i].get(j) == 1) {
						temp = 1;
					}
					else if (field[i].get(j) == 2 && temp == 1) {
						temp = 0;
						answer++;
					}
				}
			}
			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}
}
