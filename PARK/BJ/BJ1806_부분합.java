package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1806_부분합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int cnt[] = new int[N];
        for (int i = 0; i < N; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
            if(cnt[i]>=M) {
                System.out.println(1); return;}
        }
        int s = 0,e = 0;
        int now = cnt[0];

        int result = 999999;
        int test = 0;
        while(s <= N-1){
            test++;

            if( now >= M && s <= e ){ // 넘었다면
                now -= cnt[s++];


            }else if(e < N-1){
                now+= cnt[++e];

            }else{
                break;
            }

            if(now >= M) result = Math.min(result,e-s+1);
        }
        if(result == 999999) result = 0;
        System.out.println(result);
    }
}
