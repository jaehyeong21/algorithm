import java.util.Scanner;

public class Boj11050 {
    public static int f(int a){
        if(a == 0){
            return 1;
        }
        return a * f(a -1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(f(N) / (f(K) * f(N-K)));
    }
}
