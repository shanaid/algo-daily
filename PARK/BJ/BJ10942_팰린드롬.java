import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10942_팰린드롬 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] num = new int[N+1];

        for(int i = 1; i<=N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        next: for(int i = 1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int fr = Integer.parseInt(st.nextToken());
            int se = Integer.parseInt(st.nextToken());

            while(fr < se){
                if(num[fr] !=num[se]){
                    sb.append(0).append("\n");
                    continue next;
                }
                fr++;
                se--;
            }
            sb.append(1).append("\n");
        }

        System.out.println(sb);
    }
}
