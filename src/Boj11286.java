import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int num1 = Math.abs(o1);
                int num2 = Math.abs(o2);

                if(num1 == num2){
                    return o1 - o2;
                }else{
                    return num1 - num2;
                }
            }
        });

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(sc.nextLine());

            if (num == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(num);
            }
        }
    }
}
