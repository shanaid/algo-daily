import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1197_최소스패닝트리 {

    static class Node implements Comparable<Node>{
        int to;
        int value;

        Node(int to, int value){
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o){
            return this.value-o.value;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken())+1; // 정점의 수 근데 1부터 시작
        int E = Integer.parseInt(st.nextToken()); // 간선의 수

        boolean[] vis = new boolean[V];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        List<List<Node>> list = new ArrayList<>();

        for(int i = 0; i<V; i++){
            list.add(new ArrayList<>());
        }

        for(int a = 0; a<E; a++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to,value));
            list.get(to).add(new Node(from,value));
        }

        int cnt = 1;
        int result = 0;

        vis[1] = true;
        for(Node n : list.get(1)){
            pq.add(n);
        }

        while(cnt < V-1){
            Node now = pq.poll();
            if(vis[now.to]) continue;
            vis[now.to]= true;
            cnt++;
            result += now.value;
            for(Node n : list.get(now.to)){
                if(vis[n.to]) continue;
                pq.add(n);
            }
        }

        System.out.println(result);
    }
}
