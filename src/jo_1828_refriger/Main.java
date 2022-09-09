package jo_1828_refriger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		int answer = 0;
		int start = 10001;
		int end = -271;

		int N = Integer.parseInt(br.readLine());

		chemi[] temp = new chemi[N];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			temp[i] = new chemi(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}

		Arrays.sort(temp);

		for (int i = 0; i < N; i++) {
			if ((temp[i].start > end && temp[i].end > end) || (temp[i].start < start && temp[i].end < end)) {
				answer++;
				start = temp[i].start;
				end = temp[i].end;
			}
			else {
				end = Math.min(temp[i].end, end);
				start = Math.max(temp[i].start, start);
			}
		}

		System.out.println(answer);

	}

	static class chemi implements Comparable<chemi> {
		int start;
		int end;

		public chemi(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(chemi a) {
			return this.start - a.start;
		}
	}
}