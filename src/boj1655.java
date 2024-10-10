import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();


        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());

            if(maxHeap.size() == 0 || num <= maxHeap.peek()){
                minHeap.add(num);
            } else if (minHeap.size() > maxHeap.size()){
                maxHeap.add(minHeap.poll());
            }

            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
