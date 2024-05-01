import java.util.Scanner;

public class Boj14501 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] T = new int[N];
        int[] P = new int[N];
        int[] dp = new int[N + 1];

        for(int i = 0; i < N; i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for (int i = N - 1; i >= 0; i--) {
            int nextDay = i + T[i];
            if (nextDay <= N) {
                dp[i] = Math.max(P[i] + dp[nextDay], dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[0]);
    }
}
