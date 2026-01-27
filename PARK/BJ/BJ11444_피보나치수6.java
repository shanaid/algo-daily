import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
/**
 * 작성자: 박예본
 * 이메일: goodyebon123@naver.com
 * 생성일: 26. 1. 9. 오전 12:32
 * 파일명: BJ11444_피보나치수6
 */
public class BJ11444_피보나치수6 {

    static class matrix{
        long a00,a01,a10,a11;

        matrix(long a00, long a01, long a10, long a11){
            this.a00 = a00;
            this.a01 = a01;
            this.a10 = a10;
            this.a11 = a11;
        }

        static matrix multiply(matrix o1, matrix o2){
            matrix mat = new matrix(((o1.a00*o2.a00)+(o1.a01*o2.a10))%max,((o1.a00 *o2.a01)+(o1.a01*o2.a11))%max
                                        ,((o1.a10*o2.a00)+(o1.a11*o2.a10))%max,((o1.a10 *o2.a01)+(o1.a11*o2.a11))%max);
        return mat;
        }

    }
    final static long max = 1_000_000_007L;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        matrix Value = new matrix(1,1,1,0);
        matrix result = new matrix(1,0,0,1);

        for(int i = 0; i< Long.SIZE ; i++) {

            if( ( N & (1L << i)) == 1L << i ){
                result = matrix.multiply(result,Value);
            }
            Value = matrix.multiply(Value,Value);
        }

        System.out.println(result.a01);
    }
}
