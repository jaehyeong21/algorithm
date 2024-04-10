import java.util.Scanner;

public class Boj10870 {

    public static int fibo(int i){
        if(i < 2)return i;
        return fibo(i-1) + fibo(i-2);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(fibo(N));
    }
}
