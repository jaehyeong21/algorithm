import java.util.Scanner;

public class Boj1010 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < T; i++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(combination(M, N));
        }
    }
    public static long combination(int n, int r) {
        long[][] dp = new long[n + 1][r + 1];

        // nCr = n-1Cr-1 + n-1Cr
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[n][r];
    }
}
