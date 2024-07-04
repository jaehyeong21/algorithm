import java.io.*;
import java.util.StringTokenizer;

public class Boj4963 {

    static int w, h;
    static int[][] map; // 지도
    static boolean[][] visited;

    // 8방향 (상, 하, 좌, 우, 대각선)
    static int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}, // 상, 하, 좌, 우
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}  // 대각선
    };

    public static void dfs(int x, int y) {
        visited[y][x] = true;

        // 8방향으로 이동
        for (int i = 0; i < directions.length; i++) {
            int nx = x + directions[i][1];
            int ny = y + directions[i][0];

            // 범위를 벗어났는지 확인 + 섬이 있는지 확인
            if (nx < 0 || ny < 0 || nx >= w || ny >= h || map[ny][nx] == 0) {
                continue;
            }
            if (!visited[ny][nx]) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Scanner와 유사
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // System.out.println();과 유사

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int y = 0; y < h; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < w; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    if (map[y][x] == 1 && !visited[y][x]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }
            bw.write(count + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
