package boj1557;
//제곱ㄴㄴ수 실패 (시간초과)

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long K = Long.parseLong(br.readLine());

        for (int i = 2; i <= K; i++) {
            for (int j = 2; j * j <= K; j++) {
                if (i % (j * j) == 0) {
                    K++;
                    break;
                }
            }
        }

        System.out.println(K);
    }
}
