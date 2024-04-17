import java.util.Scanner;

public class Boj9417 {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split(" ");
            int maxGCD = 0; // 최대공약수를 저장할 변수

            // 모든 두 수의 쌍을 조합해 최대 공약수 구함
            for (int j = 0; j < input.length; j++) {
                for (int k = j + 1; k < input.length; k++) {
                    int num1 = Integer.parseInt(input[j]);
                    int num2 = Integer.parseInt(input[k]);
                    maxGCD = Math.max(maxGCD, gcd(num1, num2));
                }
            }

            System.out.println(maxGCD);
        }
    }
}
