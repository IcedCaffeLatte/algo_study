package boj_1759_makePassword;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	static int N, M, con = 0, col = 0; // con = 자음, col = 모음
	static char[] password;
	static Stack<Character> st = new Stack<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		password = new char[M];

		input = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			password[i] = input[i].charAt(0);
		}

		// 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을 것
		// = 정렬하면 해결
		Arrays.sort(password);

		search(0);
		
		System.out.println(sb);
	}

	public static void search(int pos) {
		// 탈출조건
		if (st.size() == N && con > 1 && col > 0) {
			for (int i = 0; i < N; i++) {
				sb.append(st.get(i));
			}
			sb.append("\n");
			return;
		}
		else if (st.size() == N || pos == M) {
			return;
		}
		
		//자음 모음 개수 파악
		st.add(password[pos]);
		switch (password[pos]) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			col++;
			break;
		default:
			con++;
			break;
		}
		search(pos + 1);
		
		switch (st.pop()) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			col--;
			break;
		default:
			con--;
			break;
		}
		search(pos + 1);
	}
}
