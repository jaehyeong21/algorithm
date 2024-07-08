import java.util.Scanner;

public class Boj2023 {
    static int m = 0;
    public static boolean isPrime(int n) {
        if (n <2) return false;
        for(int i=2; i<=Math.ceil(Math.sqrt(n)); i++){
            if(n%i==0) return false;
        }
        return true;
    }

    public static void dfs(int val, int len) {
        if(len == m) {
            System.out.println(val);
            return;
        }

        for(int i=1; i<=9; i+=2) {
            int temp = val*10+i;
            if(isPrime(temp)) dfs(val*10+i, len+1);
        }
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        m = sc.nextInt();

        int[] start = {2,3,5,7};

        for(int i=0; i<4; i++){
            dfs(start[i],1);
        }

    }
}
