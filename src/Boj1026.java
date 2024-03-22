import java.util.Arrays;
import java.util.Scanner;

public class Boj1026 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[] A = new int[N];
        int[] B = new int[N];
        int res = 0;

        String[] strA = sc.nextLine().split(" "); // A할당
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(strA[i]);
        }
        Arrays.sort(A); //오름차순

        String[] strB = sc.nextLine().split(" "); // B할당
        for(int i = 0; i < N; i++){
            B[i] = Integer.parseInt(strB[i]);
        }
        Arrays.sort(B); //오름차순

        for(int i = 0; i < N; i++){
            res += A[i] * B[N-1-i]; //A는 앞에서 뒤로, B는 뒤에서 앞으로
        }

        System.out.println(res);
    }
}
