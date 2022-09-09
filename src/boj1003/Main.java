package boj1003;
//피보나치 수열 성공

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int fiboBeforeZero = 1;
            int fiboAfterZero = 0;

            int fiboBeforeOne = 0;
            int fiboAfterOne = 1;

            int temp = 0;

            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                sb.append(fiboBeforeZero + " " + fiboBeforeOne + "\n");
            } else if (N == 1) {
                sb.append(fiboAfterZero + " " + fiboAfterOne + "\n");
            } else {
                for (int n = 2; n <= N; n++) {
                    // 0 처리
                    temp = fiboAfterZero;
                    fiboAfterZero = fiboBeforeZero + fiboAfterZero;
                    fiboBeforeZero = temp;

                    // 1 처리
                    temp = fiboAfterOne;
                    fiboAfterOne = fiboBeforeOne + fiboAfterOne;
                    fiboBeforeOne = temp;
                }
                sb.append(fiboAfterZero + " " + fiboAfterOne + "\n");
            }
        }

        System.out.println(sb);
    }
}
