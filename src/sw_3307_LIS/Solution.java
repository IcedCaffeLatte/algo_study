package sw_3307_LIS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int[] LIS;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		String[] input;

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			LIS = new int[N];
			int length = 0;
			input = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}
			LIS[0] = arr[0];
			for (int i = 1; i < N; i++) {
				if (arr[i] > LIS[length]) {
					LIS[++length] = arr[i];
				}
				else {
					LIS[Math.abs(Arrays.binarySearch(LIS, 0, length, arr[i]))+1] = arr[i];
				}
			}

			sb.append("#" + t + " " + (length + 1) + "\n");
		}
		System.out.println(sb);
	}
}
