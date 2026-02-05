package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20040_사이클게임 {

    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 0 ~ N-1개의 점이 있다. 게임 플레이어 누가 이겼는지 중요하지 않다. 근데 N이 중요한가?
        // 유니온파인드 해서 중간에 잡는 순간?
        int result = 0;

        map = new int[N];  // 0 ~ N까지

        for (int i = 0; i < N; i++) {
            map[i] = i;
        }

        for(int k = 1; k <= M; k++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(find(x) == find(y)){
                result = k;
                break;
                // 뿌리가 같다면 같은 거니까 끝
            }
            union(x,y);
        }

        System.out.println(result);

    }

    public static void union(int a, int b){
        int aa = find(a);
        int bb = find(b);
        if (map[aa] < map[bb]) {
            map[bb] = aa;
            return;
        }
        map[aa] = bb;

    }

    public static int find(int a){
        if(a == map[a]){
            return a;
        }else{
            return map[a] = find(map[a]);
        }
    }

}
