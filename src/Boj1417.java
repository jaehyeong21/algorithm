import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj1417 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 후보수
        int dasom = sc.nextInt(); // 다솜이의 득표수

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //최대 힙

        for(int i = 1; i < N; i++){
            pq.add(sc.nextInt());
        }

        int num = 0; // 뇌물 횟수

        while(!pq.isEmpty() && pq.peek() >= dasom){
            int top = pq.poll();
            top--;
            dasom++;
            pq.add(top);
            num++;
        }

        System.out.println(num);
    }
}
