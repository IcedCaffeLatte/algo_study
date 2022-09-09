package boj_3109_bakery;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[][] map;
	static int R, C, path = 0;
	static boolean find = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		String temp;
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			temp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		
		// 가장 왼쪽부터 한행씩 차례대로 출발
		for (int i = 0; i < R; i++) {
			find = false;
			search(0, i);
		}

		System.out.println(path);
	}

	// 길찾기
	// 본 코드는 받아왔던 map을 visited로 삼아서 따로 visited를 만들지 않았음

	// 해당 문제는 오른쪽 위, 오른쪽, 오른쪽 아래 만 탐색하면 되므로
	// dx, dy를 따로 만들지 않아 비슷한 구문이 3번 쓰였음

	static void search(int x, int y) {
		// 맵에 직접 방문했음을 알림
		// 어차피 갔던길이나 건물 있는 곳이나 똑같이 못가니 'x'를 넣음
		map[y][x] = 'x';

		// x가 끝에 도착했으니 종료
		if (x == C - 1) {
			path++;
			find = true;
			return;
		}

		// 해당 파이프가 제일 오른쪽에 도착했으니 종료
		if (find == true) {
			return;
		}
		// 오른쪽 위
		if (y - 1 >= 0 && map[y - 1][x + 1] == '.') {
			search(x + 1, y - 1);
		}
		if (find == true) {
			return;
		}
		// 오른쪽
		if (map[y][x + 1] == '.') {
			search(x + 1, y);
		}
		if (find == true) {
			return;
		}
		// 오른쪽 아래
		if (y + 1 < R && map[y + 1][x + 1] == '.') {
			search(x + 1, y + 1);
		}
		
		// map[y][x] = '.'; 으로 되돌려주지 않는 이유는
		// 어차피 이 길을 따라가면 이미 도착했던 길이거나
		// 도착하지 못하니 아예 접근 자체를 막아버리는 것
	}
}
