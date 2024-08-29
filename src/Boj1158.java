import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt(); // 사람의 수
        int k = sc.nextInt(); // 제거할 순서

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            queue.offer(i);
        }

        sb.append("<");

        while (!queue.isEmpty()) {
            for(int i = 0; i < k - 1; i++){
                queue.offer(queue.poll());
            }

            sb.append(queue.poll());
            if(!queue.isEmpty()){
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb.toString());
    }
}
