import java.util.Scanner;

public class Boj1012 {

    // 배추밭의 크기와 배추의 위치 정보
    public static int[][] field;
    public static boolean[][] visited;
    public static int M, N, K;

    // 상하좌우 이동을 위한 방향 배열
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    // DFS 메소드
    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            //(0,-1) 위로 이동, (0, 1) 아래로 이동, (-1, 0) 왼쪽으로 이동, (1,0) 오른쪽으로 이동
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 새로운 좌표(nx, ny) 가 유효 범위내에 있는지 확인
            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                // nx,ny에 배추가 있고 아직 방문하지 않았다면
                if (field[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny); //새로운 좌표 (nx, ny)에서 다시 재귀
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        while (T-- > 0) {
            M = sc.nextInt(); // 배추밭의 가로 길이
            N = sc.nextInt(); // 배추밭의 세로 길이
            K = sc.nextInt(); // 배추가 심어진 위치의 개수

            field = new int[M][N]; //밭 표현
            visited = new boolean[M][N]; // 방문 여부

            // 배추 위치 입력
            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                field[x][y] = 1; //배추가 있는 곳의 좌표에 1 값 입력
            }

            int Count = 0;

            // 모든 배추 위치에 대해 DFS 수행
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        Count++;
                    }
                }
            }

            System.out.println(Count);
        }

        sc.close();
    }
}