import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj1697 {
    static int N, K;
    static int[] dx = {1, -1, 2}; //이동 가능한 방향
    static boolean[] visited = new boolean[100001];  // 크기 수정
    static int[] distances = new int[100001];  // 각 위치까지의 거리를 저장

    public static int bfs(int cur){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(cur);
        visited[cur] = true;

        while(!queue.isEmpty()){  // 조건 수정
            int currentN = queue.poll();

            if(currentN == K){
                return distances[currentN];
            }

            for(int j = 0; j < 3; j++){
                int next;
                if(j < 2){
                    next = currentN + dx[j];
                } else {
                    next = currentN * dx[j];  // 여기에서 곱셈으로 수정
                }

                if(next < 0 || next > 100000 || visited[next]){
                    continue;
                }

                visited[next] = true;
                distances[next] = distances[currentN] + 1;  // 거리 업데이트
                queue.offer(next);
            }
        }
        return -1;  // 만약 목표에 도달하지 못할 경우
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        System.out.println(bfs(N));
    }
}
