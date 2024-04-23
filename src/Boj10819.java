import java.util.Scanner;

public class Boj10819 {
    static int maxDiff = Integer.MIN_VALUE; //최솟값으로 설정

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        permutation(arr, 0);

        System.out.println(maxDiff);
    }

    static void permutation(int[] arr, int depth) {
        if (depth == arr.length) {
            calculateMaxDiff(arr);
            return;
        }

        for (int i = depth; i < arr.length; i++) {
            swap(arr, i, depth);
            permutation(arr, depth + 1);
            swap(arr, i, depth);
        }
    }

    static void calculateMaxDiff(int[] arr) {
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            sum += Math.abs(arr[i] - arr[i - 1]);
        }
        maxDiff = Math.max(maxDiff, sum);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
