package boj_1931_meetingroom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		int answer = 0;
		int start = -1;

		int N = Integer.parseInt(br.readLine());

		time[] meet = new time[N];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			meet[i] = new time(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}

		Arrays.sort(meet);

		for (int i = 0; i < N; i++) {
			if (meet[i].start >= start) {
				answer++;
				start = meet[i].end;
			}
		}
		
		System.out.println(answer);

	}

	static class time implements Comparable<time> {
		int start;
		int end;

		public time(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(time a) {
			int temp = this.end - a.end;
			if (temp != 0) {
				return temp;
			}

			return this.start - a.start;
		}
	}
}
