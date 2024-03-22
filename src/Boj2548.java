import java.util.Arrays;
import java.util.Scanner;

public class Boj2548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[] A = new int[N];
        String[] str = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(str[i]);
        }
        //중간값을 찾아라
        Arrays.sort(A);

        if (N % 2 == 0) {
            System.out.println(A[N / 2 - 1]);
        } else {
            System.out.println(A[N / 2]);
        }
    }
}
