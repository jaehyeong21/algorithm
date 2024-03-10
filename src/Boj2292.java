import java.util.Scanner;

public class Boj2292 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A = 1;
        int res = 1;

        while(A < N){
            A = A + (6 * res);
            res++;
        }
        System.out.println(res);
    }
}
