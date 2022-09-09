package sw_1767_ConnectProcessor;

import java.io.*;
import java.util.*;

public class Solution {
	static int[][] map;
	static int N, arrsize;
	static ArrayList<xy> arr;
	static int wire, min, maxcnt, cnt;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());
		String[] input;

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			arr = new ArrayList<>();
			wire = 0;
			min = Integer.MAX_VALUE;
			cnt = 0;
			maxcnt = 0;

			for (int i = 0; i < N; i++) {
				input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					if (Integer.parseInt(input[j]) == 1) {
						arr.add(new xy(j, i));
					}
				}
			}

			dfs(0);

			sb.append("#" + t + " " + min + "\n");
		}
		System.out.print(sb);
	}

	static void dfs(int pos) {
		// 모든 코어를 판단했을 경우
		if (pos == arr.size()) {
			if (cnt > maxcnt) {
				min = wire;
				maxcnt = cnt;
			}
			if (cnt == maxcnt) {
				min = Math.min(min, wire);
			}
			return;
		}
		
		//이 코어를 선택한 경우
		if (map[arr.get(pos).y][arr.get(pos).x] == 0) {
			map[arr.get(pos).y][arr.get(pos).x] = pos + 2;
			cnt++;
			if (arr.get(pos).y == 0 || arr.get(pos).x == 0 || arr.get(pos).y == N - 1 || arr.get(pos).x == N - 1) {
				dfs(pos + 1);
			}
			else {
				for (int i = 0; i < 4; i++) {
					// 전선 그리기
					int nx = arr.get(pos).x + dx[i];
					int ny = arr.get(pos).y + dy[i];
					while (nx >= 0 && ny >= 0 && nx < N && ny < N) {
						if (map[ny][nx] == 0) {
							map[ny][nx] = pos + 2;
							wire++;
							if (nx == 0 || ny == 0 || nx == N - 1 || ny == N - 1) {
								dfs(pos + 1);
								break;
							}
						}
						else {
							break;
						}
						nx += dx[i];
						ny += dy[i];
					}

					// 전선 원래대로
					nx = arr.get(pos).x + dx[i];
					ny = arr.get(pos).y + dy[i];
					while (nx >= 0 && ny >= 0 && nx < N && ny < N) {
						if (map[ny][nx] == pos + 2) {
							map[ny][nx] = 0;
							wire--;
						}
						else {
							break;
						}
						nx += dx[i];
						ny += dy[i];
					}
				}
			}
			cnt--;
			map[arr.get(pos).y][arr.get(pos).x] = 0;
		}
		
		// 이 코어를 버리고 가는 경우
		dfs(pos + 1);
	}
}

class xy {
	int x, y;

	public xy(int x, int y) {
		this.x = x;
		this.y = y;
	}
}