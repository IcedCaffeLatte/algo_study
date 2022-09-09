package sw_5644_wirelessCharge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int M, A;
		int[][] userMove;
		int total;

		String[] input;

		for (int t = 1; t <= T; t++) {
			// 변수 초기화 및 입력받기 구간
			input = br.readLine().split(" ");
			M = Integer.parseInt(input[0]);
			A = Integer.parseInt(input[1]);
			userMove = new int[2][M];
			total = 0;
			xy[] userPos = { new xy(0, 0), new xy(9, 9) };
			AP[] ap = new AP[A];

			for (int i = 0; i < 2; i++) {
				input = br.readLine().split(" ");
				for (int j = 0; j < M; j++) {
					userMove[i][j] = Integer.parseInt(input[j]);
				}
			}

			for (int i = 0; i < A; i++) {
				input = br.readLine().split(" ");
				ap[i] = new AP(Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]) - 1,
						Integer.parseInt(input[2]), Integer.parseInt(input[3]));
			}
			Arrays.sort(ap);
			// 입력받는 구간 끝

			int[] select = new int[2];
			for (int m = 0; m <= M; m++) {
				select[0] = -1;
				select[1] = -1;
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < A; j++) {
						if (Math.abs(userPos[i].x - ap[j].x) + Math.abs(userPos[i].y - ap[j].y) <= ap[j].range) {
							select[i] = j;
							break;
						}
					}
				}

				// 선택한 AP가 같을 때
				if (select[0] != -1 && select[0] == select[1]) {
					int selectTemp = select[1];

					// 다른 AP찾기
					for (int i = 0; i < 2; i++) {
						for (int j = select[i] + 1; j < A; j++) {
							if (Math.abs(userPos[i].x - ap[j].x) + Math.abs(userPos[i].y - ap[j].y) <= ap[j].range) {
								select[i] = j;
								break;
							}
						}
					}

					// 다른 AP가 둘다 나왔을 때
					if (select[0] != selectTemp && select[1] != selectTemp) {
						// 그 AP마저 똑같을 때
						if (select[0] == select[1]) {
							total += ap[select[0]].charge + ap[selectTemp].charge;
						}
						// 둘 중 충전량이 더 큰 AP의 충전량 추가
						else {
							total += ap[selectTemp].charge
									+ ((select[0] < select[1]) ? ap[select[0]].charge : ap[select[1]].charge);
						}
					}
					// 하나만 나왔을 때
					else if (select[0] != selectTemp) {
						total += ap[select[0]].charge + ap[selectTemp].charge;
					}
					else if (select[1] != selectTemp) {
						total += ap[select[1]].charge + ap[selectTemp].charge;
					}
					// 다른 AP조차 없을 때 나눠서 충전 = 그 AP 한번만 더하기
					else {
						total += ap[selectTemp].charge;
					}

				}
				// AP가 같지 않으면 추가
				else {
					if (select[0] != -1) {
						total += ap[select[0]].charge;
					}

					if (select[1] != -1) {
						total += ap[select[1]].charge;
					}
				}

				if (m == M) {
					break;
				}
				// 좌표이동
				for (int i = 0; i < 2; i++) {
					switch (userMove[i][m]) {
					case 1:
						userPos[i].y--;
						break;
					case 2:
						userPos[i].x++;
						break;
					case 3:
						userPos[i].y++;
						break;
					case 4:
						userPos[i].x--;
						break;
					}
				}
			}
			sb.append("#" + t + " " + total + "\n");
		}
		System.out.println(sb);
	}

	static class xy {
		int x, y;

		public xy(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class AP implements Comparable<AP> {
		int x, y, range, charge;

		public AP(int x, int y, int range, int charge) {
			this.x = x;
			this.y = y;
			this.range = range;
			this.charge = charge;
		}

		@Override
		public int compareTo(AP a) {
			return a.charge - this.charge;
		}
	}
}
