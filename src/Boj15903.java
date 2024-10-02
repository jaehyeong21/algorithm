import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 카드 개수
        int M = Integer.parseInt(st.nextToken());  // 합치는 횟수
        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(Long.parseLong(st.nextToken()));  // 카드 값 입력
        }

        for (int i = 0; i < M; i++) {
            long num1 = pq.poll();
            long num2 = pq.poll();
            long sum = num1 + num2;
            pq.offer(sum);
            pq.offer(sum);
        }

        long result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        System.out.println(result);
    }
}
