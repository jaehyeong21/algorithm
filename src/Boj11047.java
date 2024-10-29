import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 동전의 종류
        int total = Integer.parseInt(st.nextToken()); // 목표 금액

        int[] coins = new int[N];
        int count = 0;

        for(int i = 0; i < N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        for(int i = N - 1; i >= 0; i--){
            if(coins[i] <= total){
                count = count + (total/coins[i]);
                total = total%coins[i];
            }
        }

        System.out.println(count);
    }
}
