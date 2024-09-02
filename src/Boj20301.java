import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Boj20301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        int count = 0;
        boolean leftToRight = true;

        sb.append("<");

        while (!deque.isEmpty()) {
            if (leftToRight) {
                for (int i = 0; i < k - 1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
                sb.append(deque.pollFirst());
            } else {
                for (int i = 0; i < k - 1; i++) {
                    deque.offerFirst(deque.pollLast());
                }
                sb.append(deque.pollLast());
            }

            count++;

            if (!deque.isEmpty()) {
                sb.append(", ");
            }

            if (count % m == 0) {
                leftToRight = !leftToRight;
            }
        }

        sb.append(">");
        System.out.println(sb.toString());

        sc.close();
    }
}
