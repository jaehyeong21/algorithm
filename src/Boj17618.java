import java.util.Scanner;

public class Boj17618 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int res = 0;

        for(int i = 1; i <= N; i++){
            int temp = i;
            int A = 0;
            while (temp != 0){
                A = A + temp % 10;
                temp = temp/10;
            }
            if(i % A == 0){
                res++;
            }
        }
        System.out.print(res);
    }
}
