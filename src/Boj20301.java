import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj20301 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Deque<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            q.add(i);
        }

        int removedCount = 0; // 제거된 사람의 수
        int directionCount = 0; // 현재 방향에서 제거된 횟수
        boolean isLeftToRight = true; // 방향이 오른쪽인지 왼쪽인지

        while (!q.isEmpty()) {
            int number;

            if (isLeftToRight) {
                // K번째를 찾기 위해 K-1번 앞의 요소를 뒤로 보낸다.
                for (int i = 0; i < K - 1; i++) {
                    number = q.pollFirst();
                    q.addLast(number);
                }
                // K번째 사람을 제거한다.
                number = q.pollFirst();
            } else {
                // K번째를 찾기 위해 K-1번 뒤의 요소를 앞으로 보낸다.
                for (int i = 0; i < K - 1; i++) {
                    number = q.pollLast();
                    q.addFirst(number);
                }
                // K번째 사람을 제거한다.
                number = q.pollLast();
            }

            sb.append(number).append("\n"); // 제거된 사람 기록
            removedCount++;
            directionCount++;

            // M번 제거했으면 방향을 바꾼다.
            if (directionCount == M) {
                isLeftToRight = !isLeftToRight;
                directionCount = 0;
            }
        }

        System.out.print(sb);
    }
}
