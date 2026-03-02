import java.util.*;
import java.io.*;

public class BJ27172_수나누기게임 {

    static int N;
    static int[] num, point;
    static boolean[] vis;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N+1];
        point = new int[N+1];
        vis = new boolean[1_000_001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 1; i<=N; i++){
            int tmp =Integer.parseInt(st.nextToken());
            num [i] = tmp;
            vis [tmp] = true;
            map.put(tmp,i); // 어떤 숫자가 어디에 있는지
        }
        // 1 ~ 100,000
        // 1. Map에 숫자 있다면 0 ~ 내 N까지 숫자를 돌리기

        // 내 숫자를 계속 곱해서 겹치는 애들만 +- 처리를 해준다.
        for(int k = 1; k<=N; k++){
//            System.out.println(k);

            g:for( int j = 2; j <= 1_000_000 ; j ++ ){
                int val = j * num[k];
//                System.out.println(num[k]+" "+j+" "+ val );

                if(val > 1_000_000) break g;

                if(vis[j * num[k]]){ // 있다는 뜻
                    point[k]++; // 당첨자 포인트 깍고
                    point[map.get(j * num[k])]--; // 더블인 애 올리고
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        for(int k = 1; k<=N; k++){
            sb.append(point[k]+" ");
        }
        System.out.print(sb);

    }
}
