import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj20301try {
    public static void main(String[] args) throws Exception{
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 총 몇명인지
        int K = Integer.parseInt(st.nextToken()); // 3이라고 하면 3번째 사람을 계속 제거
        int M = Integer.parseInt(st.nextToken()); // 제거 될 때마다 위치 변경

        Deque<Integer> q = new LinkedList<>();


        for(int i = 1; i <= N; i++){
            q.add(i);
        }

        int removeCount = 0; // 제거된 사람의 수
        int directionCount = 0; // 현재 방향에서 제거된 횟수
        boolean LeftToRight = true;

        while(!q.isEmpty()){
            int number;

            if(LeftToRight){
                for(int i = 0; i < K-1; i++){
                    number = q.pollFirst();
                    q.addLast(number);
                }
                // K번째 사람 제거
                number = q.pollFirst();
            }else{
                for(int i = 0; i < K-1; i++){
                    number = q.pollLast();
                    q.addFirst(number);
                }
                number = q.pollLast();
            }

            sb.append(number).append("\n"); // 제거된 사람 기록
            removeCount++;
            directionCount++;

            if(directionCount == M){
                LeftToRight = !LeftToRight;
                directionCount = 0;
            }
        }
        System.out.println(sb);
    }
}
