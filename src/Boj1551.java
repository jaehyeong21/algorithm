import java.util.Scanner;

public class Boj1551 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        String[] str1 = sc.nextLine().split(",");
        int[] arr = new int[N];

        // 입력된 문자열을 정수 배열로 변환
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str1[i]);
        }

        // K번의 연산을 수행한 후의 결과를 구함
        for (int j = 0; j < K; j++) {
            for (int i = 0; i < N - 1; i++) {
                arr[i] = arr[i + 1] - arr[i];
            }
            N--; // 연산 후 배열의 크기를 줄임
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]);
            if (i < N - 1) {
                System.out.print(",");
            }
        }
    }
}
