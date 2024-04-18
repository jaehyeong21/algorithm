import java.util.Scanner;

public class Boj14888 {

    public static int n; //수의 개수
    public static int[] A = new int[11]; //수들의 배열
    public static int[] op = new int[4]; //연산자 갯수
    public static int max = Integer.MIN_VALUE; // int 범위의 가장 작은 값
    public static int min = Integer.MAX_VALUE; // int 범위의 가장 큰 값
    public static void solve(int total, int idx,
                             int add, int sub, int multi, int div){
        if(idx == n){
            //최대값
            max = Math.max(max, total);
            //최소값
            min = Math.min(min, total);
            return;
        }

        if (add > 0) solve(total + A[idx], idx + 1, add - 1, sub, multi, div);
        if (sub > 0) solve(total - A[idx], idx + 1, add, sub - 1, multi, div);
        if (multi > 0) solve(total * A[idx], idx + 1, add, sub, multi - 1, div);
        if (div > 0) solve(total / A[idx], idx + 1, add, sub, multi, div - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) A[i] = sc.nextInt();
        for(int i = 0; i < 4; i++) op[i] = sc.nextInt();

        solve(A[0], 1, op[0], op[1], op[2], op[3]);

        System.out.println(max);
        System.out.println(min);
    }
}
