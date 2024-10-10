import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int num = 0;
        int res = 0;

        for(int i = 0; i < N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        while(pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            num = first + second;
            res = res + num;
            pq.add(num);
        }
        System.out.println(res);
    }
}
