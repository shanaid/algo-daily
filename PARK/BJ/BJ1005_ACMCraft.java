/**
 * 작성자: 박예본
 * 이메일: goodyebon123@naver.com
 * 생성일: 26. 3. 2. 오후 3:18
 * 파일명: BJ1005_ACMCraft
 */
import java.util.*;
import java.io.*;
public class BJ1005_ACMCraft {
    static int memo[], time[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for(int n = 0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int B = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            time = new int[B+1];
            memo = new int[B+1];
            Arrays.fill(memo,-1);
            boolean findRoot[] = new boolean[B + 1];
            int result = 0;

            List<Integer>[] list = new ArrayList[B+1];
            st = new StringTokenizer(br.readLine());

            for(int b = 1; b<=B; b++){ // 시간
                time[b] = Integer.parseInt(st.nextToken());
                list[b] = new ArrayList();
            }

            // 이제 순서
            for(int r = 1; r<=R; r++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                findRoot[to] = true;
                list[to].add(from);
            }



            int goal = Integer.parseInt(br.readLine());
            Queue<Integer> q = new LinkedList();
            q.add(goal);
            int resultCnt = find(goal, list, findRoot);
            System.out.println(resultCnt);
        }

    }

    static int find (int now, List<Integer>[] list,boolean[] root){
        if(!root[now]){
            return time[now]; }// 끝이 아니라면

        // 해야할 일 -> 어디서 왔는지 다 DFS 태우기 그리고 memo에 적립하기
        int all = 0;
        for(int i :list[now]){
            int time = 0;
            if(memo[i] != -1){
                time = memo[i];
            }else {
                time = find(i, list, root);
            }
            all = Math.max(all,time);
        }
        memo[now] = all + time[now];
        // 돌려줄 값
        return memo[now];
    }
}
