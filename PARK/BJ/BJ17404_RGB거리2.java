package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17404_RGB거리2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int k=0;k<3;k++){
            int[][] dp = new int[N][3]; // 초기값
            dp[0][0] = Integer.MAX_VALUE- 100000;
            dp[0][1] = Integer.MAX_VALUE- 100000;
            dp[0][2] = Integer.MAX_VALUE- 100000;
            dp[0][k] = map[0][k];

            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i-1][2], dp[i-1][1]) + map[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + map[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + map[i][2];
            }

            for (int c = 0; c < 3; c++) {
                if (c == k) continue; // 마지막 집 색 != 첫 집 색
                result = Math.min(result, dp[N-1][c]);
            }

        }
        System.out.println(result);

    }
}
