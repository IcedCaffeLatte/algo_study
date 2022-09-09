package boj_15686_chick;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int N, M;
	static boolean[] isSelected;
	static ArrayList<xy> chick;
	static ArrayList<xy> house;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		chick = new ArrayList<>();
		house = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(input[j]);
				if (temp == 2) {
					chick.add(new xy(j, i));
				}
				if (temp == 1) {
					house.add(new xy(j, i));
				}
			}
		}
		isSelected = new boolean[chick.size()];

		dfs(0, 0);

		System.out.println(min);
	}

	public static void dfs(int pos, int cnt) {
		if (cnt == M) {
			int result = 0;
			for (int i = 0; i < house.size(); i++) {
				result += minDistance(house.get(i));
				if (result >= min) {
					return;
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

	public static int minDistance(xy xy) {
		int min2 = Integer.MAX_VALUE;

		for (int i = 0; i < chick.size(); i++) {
			if (isSelected[i] == true) {
				min2 = Math.min(min2, Math.abs(chick.get(i).x - xy.x) + Math.abs(chick.get(i).y - xy.y));
			}
		}

		return min2;
	}

	static class xy {
		int x;
		int y;

		public xy(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}