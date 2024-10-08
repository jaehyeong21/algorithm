import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1966 {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int file = 0;   // 문서의 개수
        int order = 0;  // 출력 순서를 찾고자 하는 문서의 인덱스

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());  // 테스트 케이스 수

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            file = Integer.parseInt(st.nextToken());
            order = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < file; j++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{j, priority}); // {문서의 인덱스, 중요도}
            }

            int count = 0; // 출력된 문서의 수

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                boolean hasHigherPriority = false;

                // 현재 문서보다 높은 우선순위가 있는지 확인
                for (int[] q : queue) {
                    if (q[1] > current[1]) {
                        hasHigherPriority = true;
                        break;
                    }
                }

                if (hasHigherPriority) {
                    // 우선순위가 높은 문서가 있으면 현재 문서를 뒤로 보냄
                    queue.offer(current);
                } else {
                    // 그렇지 않으면 출력
                    count++;
                    if (current[0] == order) {
                        System.out.println(count);
                        break;
                    }
                }
            }
        }
    }
}
