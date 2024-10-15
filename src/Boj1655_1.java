import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Boj1655_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());

            if(maxHeap.isEmpty()){
                maxHeap.offer(num);
                bw.write(maxHeap.peek() + "\n");
            }
            else if(maxHeap.size() == minHeap.size() + 1){
                if(minHeap.peek() >= num && num >= maxHeap.peek()) maxHeap.offer(num);
                else if(num <= maxHeap.peek()) maxHeap.offer(num);
                else{
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(num);
                }
            }else{
                if(maxHeap.peek() <= num){
                    minHeap.offer(num);
                }else{
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(num);
                }
            }

            bw.write(maxHeap.peek() + "\n");
        }
    }
}
