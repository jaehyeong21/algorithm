import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj11279 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙

        for(int i = 0; i < N; i++){
            int num = sc.nextInt();

            if( num == 0) {
                if(pq.isEmpty()){
                    System.out.println(0);
                }else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(num);
            }
        }

    }
}
