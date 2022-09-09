package jo_2577_spinSushi;

import java.io.*;

// 다른 분 소스를 참고하여 문제를 이해하려고 주석을 새로 써가며 풀었습니다.

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		input = br.readLine().split(" ");

		int N = Integer.parseInt(input[0]); // 전체 초밥 개수
		int d = Integer.parseInt(input[1]); // 전체 초밥 가짓수
		int k = Integer.parseInt(input[2]); // 연속해서 먹을 초밥 개수
		int c = Integer.parseInt(input[3]); // 공짜 쿠폰

		int[] arr = new int[N];
		int[] v = new int[d + 1];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
		}

		int count = 0;
		
		// 처음 k 개 먹었을 때 가능한 가짓수
		for (int i = 0; i < k; i++) {
			if (v[arr[i]] == 0) {
				count++;
			}
			v[arr[i]]++;
		}
		
		// 일단 최소 가짓수로 answer에 저장
		int answer = count;
		
		for (int i = 1; i < N; i++) {
			if (answer <= count) {
				// 내가 고른 초밥 중에서 쿠폰 초밥이 없다?
				// 그럼 주방장이 새로 만들어서 초밥을 준다!
				if (v[c] == 0) {
					answer = count + 1;
				}
				else {
					answer = count;
				}
				
				// 최대로 나올 수 있는 가짓수가 이미 나왔다면
				if (answer == k + 1) {
					// 그만
					break;
				}
			}
			
			// 다음으로 넘어가기에 방문한 가장 처음 먹은 거 방문 해제
			v[arr[i - 1]]--;
			
			// v[i-1]==0 이라는 것은 이 초밥이 먹었던 초밥 중에서 중복되지 않았다는 뜻
			// 고로 중복되지 않은 가짓수에서 1 빼기
			if (v[arr[i - 1]] == 0) {
				count--;
			}
			
			// 다음으로 넘어간 초밥이 k 가지 초밥 중 유일한 초밥이라면 중복되지 않은 초밥이므로
			// 중복되지 않은 가짓수 1 추가
			if (v[arr[(i + k - 1) % N]] == 0) {
				count++;
			}
			
			// 여하튼간에 일단 이 초밥은 추가됨
			v[arr[(i + k - 1) % N]]++;
		}

		System.out.println(answer);
	}
}
