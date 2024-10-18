import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1012__bfs {
    static int[][] location = {{0,1},{0,-1},{1,0},{-1,0}};  // 상, 하, 좌, 우 방향 이동 좌표
    static int[][] map;
    static boolean[][] visited;
    static int M, N;

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int startY = current[0];
            int startX = current[1];
            for (int i = 0; i < location.length; i++) {
                int newY = startY + location[i][0];
                int newX = startX + location[i][1];

                // 유효한 범위 내에서 배추가 있고 아직 방문하지 않은 곳
                if (newY >= 0 && newX >= 0 && newY < N && newX < M && !visited[newY][newX] && map[newY][newX] == 1) {
                    queue.offer(new int[]{newY, newX});
                    visited[newY][newX] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 길이
            N = Integer.parseInt(st.nextToken()); // 세로 길이
            int K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치 개수

            map = new int[N][M];  // 배추밭 초기화
            visited = new boolean[N][M];  // 방문 여부 초기화

            // 배추 위치 입력
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                map[y][x] = 1;  // 배추가 있는 위치는 1로 표시
            }

            int result = 0;  // 필요한 벌레 수 (연결된 배추 그룹의 수)

            // 배추밭 탐색
            for (int z = 0; z < N; z++) {
                for (int c = 0; c < M; c++) {
                    // 아직 방문하지 않은 배추가 있으면 BFS 탐색 시작
                    if (map[z][c] == 1 && !visited[z][c]) {
                        bfs(z, c);
                        result++;  // 배추 그룹 하나 발견했으니 벌레 수 증가
                    }
                }
            }

            System.out.println(result);  // 결과 출력 (각 테스트 케이스마다)
        }
    }
}
