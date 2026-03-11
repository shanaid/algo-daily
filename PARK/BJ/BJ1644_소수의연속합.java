package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ1644_소수의연속합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1) System.out.println(0);
        boolean[] prime = new boolean[N+1]; // true 면 소수 아님
        prime[0] = true;
        prime[1] = true;

        for(int i = 2; i<Math.sqrt(N); i++){
            if(prime[i]) continue;
            for(int j = 2; j*i <= N; j++){
                prime[j*i] = true;
            }
        }
        ArrayList<Integer> list = new ArrayList();

        for(int i = N; i > 1; i--){
           if(!prime[i]) list.add(i);
       }

        int start, end, sum = 0;
        while( start<list.size() && end)

    }
}
