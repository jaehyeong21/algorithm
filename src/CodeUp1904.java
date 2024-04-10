import java.util.Scanner;

public class CodeUp1904 {

    public static void f(int a, int b){
        if(a > b)
            return;
        if(a % 2 != 0)
            System.out.print(a+" ");
        f(a+1,b);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        f(a,b);
    }
}
