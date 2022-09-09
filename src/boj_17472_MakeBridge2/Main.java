package boj_17472_MakeBridge2;

import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N, M;
	static int[][] map;
	static boolean[][] v;
	static int island = 0;
	// 항상 이런 문제에는 우선순위 큐를 사용함
	static PriorityQueue<edge> pq = new PriorityQueue<edge>();
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int bridgeCnt = 0;
		int answer = 0;
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		map = new int[N][M];
		v = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		// 섬 번호 지정용 bfs
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !v[i][j]) {
					island++;
					bfs(new xy(i, j));
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					makeBridge(new xy(i, j), map[i][j]);
				}
			}
		}

		parent = new int[island + 1];

		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		while(!pq.isEmpty()) {
			edge tmp = pq.poll();

			int a = find(tmp.s);
			int b = find(tmp.e);

			if (a != b) {
				union(tmp.s, tmp.e);
				answer += tmp.v;
				bridgeCnt++;
			}
		}

		if (answer == 0 || bridgeCnt != island - 1) {
			answer = -1;
		}
		System.out.println(answer);
	}

	static void bfs(xy d) {
		Queue<xy> q = new LinkedList<xy>();
		v[d.x][d.y] = true;
		map[d.x][d.y] = island;
		q.add(d);

		while (!q.isEmpty()) {
			xy t = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 1 && !v[nx][ny]) {
					q.add(new xy(nx, ny));
					map[nx][ny] = island;
					v[nx][ny] = true;
				}
			}
		}
	}

	public static void makeBridge(xy d, int num) {
		int x, y, length;

		for (int i = 0; i < 4; i++) {
			length = 0;
			x = d.x;
			y = d.y;
			while (true) {
				x = x + dx[i];
				y = y + dy[i];

				if (x >= 0 && x < N && y >= 0 && y < M) {
					if (map[x][y] == num) {
						break;
					}
					else if (map[x][y] == 0) {
						length++;
					}
					else {
						if (length > 1) {
							pq.add(new edge(num, map[x][y], length));
						}
						break;
					}
				}
				else {
					break;
				}
			}
		}
	}

	public static int find(int a) {
		if (a == parent[a]) {
			return a;
		}
		parent[a] = find(parent[a]);
		return parent[a];
	}

	public static void union(int s, int e) {
		int aRoot = find(s);
		int bRoot = find(e);

		if (aRoot != bRoot) {
			parent[aRoot] = e;
		}
	}
}

class xy {
	int x;
	int y;

	public xy(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class edge implements Comparable<edge> {
	int s;
	int e;
	int v;

	public edge(int s, int e, int v) {
		super();
		this.s = s;
		this.e = e;
		this.v = v;
	}

	@Override
	public int compareTo(edge arg0) {
		return arg0.v >= this.v ? -1 : 1;
	}
}