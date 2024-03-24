import java.util.Scanner;

public class Boj10448 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        for(int i = 0; i < K; i++){
            int n = sc.nextInt();
            boolean found = false;

            int num1, num2, num3;
            //브루트포스?
            // 세 개의 삼각수를 이용해 주어진 수를 만들 수 있는지 확인
            for (int j = 1; j <= n; j++) {
                num1 = (j * (j + 1)) / 2;
                if (num1 >= n) break;
                for (int k = 1; k <= n; k++) {
                    num2 = (k * (k + 1)) / 2;
                    if (num1 + num2 >= n) break;
                    for (int l = 1; l <= n; l++) {
                        num3 = (l * (l + 1)) / 2;
                        if (num1 + num2 + num3 == n) {
                            found = true;
                            break;
                        }
                        if (num1 + num2 + num3 > n) break;
                    }
                    if (found) break;
                }
                if (found) break;
            }

            // 결과 출력
            if (found) System.out.println(1);
            else System.out.println(0);
        }
    }
}
