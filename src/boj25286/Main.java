package boj25286;
// 11월 11일 성공

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String[] input;

        for (int t = 0; t < T; t++) {
            input = br.readLine().split(" ");
            int year = Integer.parseInt(input[0]);
            int month = Integer.parseInt((input[1])) - 1;
            int day;

            if (month == 0){
                month = 12;
                year--;
            }

            if (month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                day = 31;
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                day = 30;
            } else if (month == 1) {
                day = 31;
            } else {
                if (year % 400 == 0 || (year % 4 == 0 && !(year % 100 == 0))) {
                    day = 29;
                } else {
                    day = 28;
                }
            }

            sb.append(year + " " + month + " " + day + "\n");
        }
        System.out.println(sb);
    }
}
