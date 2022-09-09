package boj_15686_chick;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main2 {
	static int min = Integer.MAX_VALUE;
	static int N, M;
	static int[][] city;
	static int[][] virtualCity;
	static boolean[] isSelected;
	static ArrayList<int[]> chick;
	static final int[] DX = { 0, 0, 1, -1 };
	static final int[] DY = { 1, -1, 0, 0 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		chick = new ArrayList<>();

		city = new int[N][N];
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(input[j]);
				if (city[i][j] == 2) {
					chick.add(new int[] { i, j });
				}
			}
		}
		isSelected = new boolean[chick.size()];

		dfs(0, 0);

		System.out.println(min);
	}

	public static void dfs(int pos, int cnt) {
		if (cnt == M) {
			// 이 도시의 모든 집에서 치킨거리 구하기
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (city[i][j] == 1) {
						result += bfs(i, j);
					}
					if (result >= min) {
						return;
					}
				}
			}
			min = Math.min(min, result);
			return;
		}

		if (pos == chick.size()) {
			return;
		}

		isSelected[pos] = true;
		dfs(pos + 1, cnt + 1);
		isSelected[pos] = false;
		dfs(pos + 1, cnt);
	}

	static int bfs(int y, int x) {
		virtualCity = new int[N][N];
		for (int i = 0; i < chick.size(); i++) {
			if (isSelected[i]) {
				virtualCity[chick.get(i)[0]][chick.get(i)[1]] = 2;
			}
		}

		Queue<xyc> que = new LinkedList<>();
		que.offer(new xyc(x, y, 0));
		virtualCity[y][x] = 1;
		
		while(que.size() != 0) {
			xyc temp = que.poll();
			
			for(int d = 0 ; d < 4 ; d++) {
				int dx = temp.x + DX[d];
				int dy = temp.y + DY[d];
				
				if(dx >= 0 && dx < N && dy >= 0 && dy < N && virtualCity[dy][dx] != 1) {
					if(virtualCity[dy][dx] == 2) {
						return temp.cnt + 1;
					}
					virtualCity[dy][dx] = 1;
					que.offer(new xyc(dx, dy, temp.cnt + 1));
				}
				
			}
			
		}
		return Integer.MAX_VALUE;
	}

	static class xyc {
		int x;
		int y;
		int cnt;

		public xyc(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}