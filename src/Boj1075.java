import java.util.*;

public class Boj1075 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int F = sc.nextInt();

        N = (N - (N % 100));

        while(true){
            if(N % F == 0){
                break;
            }
            N++;
        }
            System.out.format("%02d" , (N % 100));
    }
}
