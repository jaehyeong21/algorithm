import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1743__bfs {
    static int[][] location = {{0,-1}, {0,1}, {-1,0}, {1,0}};
    static int[][] map;
    static boolean[][] visited;
    static int res = 0;

    // BFS 함수
    public static int bfs(int startY, int startX){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX});
        visited[startY][startX] = true;
        int count = 1;  // 현재 음식물의 크기

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            // 네 방향으로 탐색
            for (int i = 0; i < location.length; i++) {
                int newY = y + location[i][0];
                int newX = x + location[i][1];

                // 배열 범위를 벗어나지 않고, 아직 방문하지 않았으며 음식물이 있는 경우
                if (newY >= 0 && newX >= 0 && newY < map.length && newX < map[0].length
                        && !visited[newY][newX] && map[newY][newX] == 1) {
                    queue.offer(new int[]{newY, newX});  // 큐에 추가
                    visited[newY][newX] = true;  // 방문 표시
                    count++;  // 음식물 크기 증가
                }
            }
        }
        return count;  // 연결된 음식물 크기 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 세로 크기
        int M = Integer.parseInt(st.nextToken()); // 가로 크기
        int K = Integer.parseInt(st.nextToken()); // 음식물 쓰레기 개수

        map = new int[N][M];
        visited = new boolean[N][M];

        // 음식물 쓰레기 위치 입력
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y-1][x-1] = 1;  // 음식물 위치를 1로 표시
        }

        // 모든 좌표 탐색
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    int count = bfs(i, j);  // bfs 시작
                    res = Math.max(res, count);  // 가장 큰 음식물 크기 갱신
                }
            }
        }

        System.out.println(res);  // 결과 출력
    }
}
