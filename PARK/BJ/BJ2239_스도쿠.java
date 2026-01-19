package BJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2239_스도쿠 {

    static char[][] table ;
    static boolean s;

    public static void main(String[] args) throws Exception{

        table = new char[9][9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i<9 ; i++){
            table[i] = br.readLine().toCharArray();
        }
        s = false;
        play(0,0);
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }

    private static void play(int r, int c) {
        // 끝나는 조건

        if(r > 8) {
            s = true;
        }

        if(s) return;

        //판별식
        if(table[r][c] == '0') {

            boolean canInsert = false;

            for (int i = 1; i < 10; i++) { // 분기하는 곳
                if (test(r, c, i)) {
                    //들어갈 수 있다면
                    canInsert = true;
                    table[r][c] = (char) (i + '0');
                    int nextC = c + 1;
                    int nextR = r;
                    if (nextC == 9) {
                        nextC = 0;
                        nextR = r + 1;
                    }

                    play(nextR, nextC);
                    if(s) return;

                    table[r][c] = (char) ('0');
                }
            }
            if (!canInsert) {
                return;
            }

        }else{
            int nextC = c + 1;
            int nextR = r;
            if (nextC == 9) {
                nextC = 0;
                nextR = r + 1;
            }
            play(nextR, nextC);
        }



    }

    static boolean test(int row, int col, int num){
        for(int r = 0; r<9; r++){
            if(table[r][col] == (char)(num+'0') || table[row][r] == (char)(num+'0')){return false;}

        }
        int R = row % 3;
        int C = col % 3;
        int startR = row-R;
        int startC = col - C;
        for(int i = 0; i < 3; i++){
            for(int k = 0; k<3; k++){
                if(table[startR+i][startC+k] == (char)(num+'0')) return false;
            }
        }
        return true;
    }

}
