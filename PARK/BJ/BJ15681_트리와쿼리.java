import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class BJ15681_트리와쿼리 {
    static int[] cnt;
    static boolean[] vis;
    static List<List<Integer>> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N,R,Q;

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        cnt = new int[N+1];
        vis = new boolean[N+1];
        list = new ArrayList<>();

        for(int i =0; i<=N;i++){
            list.add(new ArrayList<>());
        }

        for(int a = 1; a<N; a++){
            st= new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
        }

        setRoot(R);

        for(int b =0; b<Q; b++){
            sb.append(cnt[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }

    private static int setRoot(int r) {
        vis[r] = true;
        int q = 1;

        for(int i =0; i<list.get(r).size();i++){
            if(vis[list.get(r).get(i)]) continue;
            int p =setRoot(list.get(r).get(i));
            q+=p;
        }

        return cnt[r] = q;
    }
}
