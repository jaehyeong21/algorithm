import java.util.Scanner;

public class Boj21735 {
    static int N,M;
    static int[] arr;
    static int ans;

    public static void solve(int size, int time, int pos){
        if(time == M || pos >= N){ // 시간이 m이 다 됐거나 길이가 N보다 클 때
            ans = Math.max(ans, size);
            return;
        }
        if(pos+1 <= N) solve(size+arr[pos+1], time+1, pos+1);
        if(pos+2 <= N) solve((size/2) + arr[pos+2], time+1, pos+2);

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = sc.nextInt();
        }

        solve(1,0,0);
        System.out.println(ans);
    }
}

