import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1182 {
    static int N, S, count;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        plus(0, 0);

        // S가 0인 경우 공집합을 제외해야 함
        if (S == 0) {
            count--;
        }

        System.out.println(count);
    }

    public static void plus(int index, int sum) {
        if (index == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        plus(index + 1, sum);

        plus(index + 1, sum + arr[index]);
    }
}
