import java.util.Arrays;
import java.util.Scanner;

public class Boj16208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long totalLength = 0;
        long total = 0;

        int N = sc.nextInt();
        long[] length = new long[(int)N];

        for(int i = 0; i < N; i++){
            length[i] = sc.nextInt();
        }

        Arrays.sort(length);

        for(int i = 0; i < N; i++){
            totalLength = totalLength + length[i];
        }

        for(int i = 0; i < N; i++){
            totalLength = totalLength - length[i];
            total = total + (length[i] * totalLength);
        }

        System.out.print(total);
    }
}
