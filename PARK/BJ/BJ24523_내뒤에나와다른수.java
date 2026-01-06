import java.util.*;
import java.io.*;

/**
 * 작성자: 박예본
 * 이메일: goodyebon123@naver.com
 * 생성일: 26. 1. 6. 오후 11:26
 * 파일명: BJ24523_내뒤에나와다른수
 */
public class BJ24523_내뒤에나와다른수 {


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            if(i == N){
                sb.append(-1).append(" ");
                break;
            }

            if(arr[i] != arr[i+1]) {
                sb.append(i+1).append(" ");
//                System.out.print(i+1);
                continue;
            }

            int test = i; // 일단 현재 배회중인 로직
            int cnt = 1; // 현재 몇번이나 뒤바꿀건가?
            boolean last = false; // 마지막인가?


            while( test < N && arr[test] == arr[test+1] ){ // 만약 같다면 다음 차례도
                cnt++;
                test++;
                if( test == N ) last = true;
            }

            if(!last){ //마지막이 아니면
                while(cnt != 0){
                    cnt --;
                    i++;
                    sb.append(test+1).append(" ");
                }
                i--;
            }else{ //마지막이면
                while(cnt != 0){
                    cnt --;
                    i ++;
                    sb.append(-1).append(" ");
                }
            }

        }

        System.out.print(sb);
    }
}
