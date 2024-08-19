import java.util.Arrays;
import java.util.Scanner;

public class Boj1337 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int result = 5;
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++){
            int count = 1;
            for(int j = i + 1; j < N; j++){
                if(arr[j] <= arr[i] + 4){
                    count++;
                }else{
                    break;
                }
            }
            result = Math.min(result, 5 - count);
        }
        System.out.print(result);
    }
}
