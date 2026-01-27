package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1647_도시분할계획 {
    static class Node implements Comparable<Node>{
        int from;
        int to;
        int value;
        Node(int to, int from, int value){
            this.to = to;
            this.from = from;
            this.value = value;
        }

        @Override
        public int compareTo(Node o){
            return this.value-o.value;
        }

    }
    static int unionfind[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        if(N == 2){
            System.out.println(0);
            return;
        }
        int M = Integer.parseInt(st.nextToken());

        unionfind = new int[N+1];
        for(int i=1;i<=N;i++){
            unionfind[i]=i;
        }
//        List<List<Node>> list = new ArrayList();
//        for(int i= 0; i<= N; i++){
//            list.add(new ArrayList());
//        }
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i= 0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
//            list.get(a).add(new Node(b, c));
//            list.get(b).add(new Node(a, c));
            pq.add(new Node(a, b, c));
        }

        int line = 0;
        int result = 0;

        while(!pq.isEmpty()){
            if(line == N-2){
                break;
            }
            Node node = pq.poll();

            if(find(node.from) != find(node.to)){

            union(node.from, node.to);
            result+=node.value;
            line++;
            }
        }
        System.out.println(result);


    }
    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            if (rootA < rootB) unionfind[rootB] = rootA;
            else unionfind[rootA] = rootB;
        }
    }

    static int find(int x ){
        if( x == unionfind[x] ) return x;
        else return unionfind[x] = find(unionfind[x]);
    }
}
