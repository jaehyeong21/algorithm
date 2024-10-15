import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[N][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();


        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        pq.offer(arr[0][1]); // 강의 첫 번째 종료시간

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= arr[i][0]) {
                pq.poll();
            }
            pq.offer(arr[i][1]);
        }

        System.out.println(pq.size());
    }
}
