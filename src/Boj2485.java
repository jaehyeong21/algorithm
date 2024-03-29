import java.util.Scanner;
import java.util.Arrays;

public class Boj2485 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            arr[i] = A;
        }
        Arrays.sort(arr);

        int[] distances = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distances[i] = arr[i + 1] - arr[i];
        }

        //인접한 나무 사이 거리의 최대 공약수
        int g = distances[0];
        for (int i = 1; i < N - 1; i++) {
            int temp = distances[i];
            while (temp != 0) {
                int r = g % temp;
                g = temp;
                temp = r;
            }
        }

        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            count += distances[i] / g - 1;
        }
        System.out.println(count);
    }
}
