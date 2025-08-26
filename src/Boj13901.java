import java.util.*;
import java.io.*;

public class Boj13901 {
    static int R, C;
    static boolean[][] map;
    static int[][] d = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    static int[] directions;
    static int finalY, finalX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        map = new boolean[R][C];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int brY = Integer.parseInt(st.nextToken());
            int brX = Integer.parseInt(st.nextToken());
            map[brY][brX] = true;
        }

        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        directions = new int[4];
        for (int i = 0; i < 4; i++) {
            directions[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        finalY = startY;
        finalX = startX;
        map[startY][startX] = true;
        dfs(startY, startX);

        System.out.println(finalY + " " + finalX);
    }

    // DFS 함수
    static void dfs(int y, int x) {
        finalY = y;
        finalX = x;

        // 방향 순서대로 이동 시도
        for (int i : directions) {
            int ny = y + d[i][0];
            int nx = x + d[i][1];

            if (ny >= 0 && ny < R && nx >= 0 && nx < C && !map[ny][nx]) {
                map[ny][nx] = true;
                dfs(ny, nx);
                return;
            }
        }
    }
}
