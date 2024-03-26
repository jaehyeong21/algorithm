import java.util.Scanner;

public class Boj2991 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A, B, C, D;
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        D = sc.nextInt();

        int P, M, N;
        P = sc.nextInt();
        M = sc.nextInt();
        N = sc.nextInt();

        int[] attacks = new int[]{P, M, N};

        for (int i = 0; i < 3; i++) {
            int count = 0;
            int attack = attacks[i];

            // 첫 번째 공격
            if (attack % (A + B) <= A && attack % (A + B) != 0)
                count++;
            // 두 번째 공격
            if (attack % (C + D) <= C && attack % (C + D) != 0)
                count++;

            System.out.println(count);
        }
    }
}
