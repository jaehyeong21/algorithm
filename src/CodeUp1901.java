import java.util.Scanner;

public class CodeUp1901 {
    static void f(int n) {
        if(n == 0)
            return ;
        f(n-1);
        System.out.println(n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        f(n);
    }//main end
}