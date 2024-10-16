import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1743 {
    static int[][] location = {{0,-1}, {0,1}, {-1,0}, {1,0}};
    static int[][] map;
    static boolean[][] visited;
    static int res = 0;
    static int N, M;

    public static int dfs(int y, int x, int count){
        count++;
        visited[y][x] = true;
        for(int i = 0; i < location.length; i++){
            int newY = y + location[i][0];
            int newX = x + location[i][1];
            if(newY < 0 || newX < 0 || newX >= M || newY >= N || visited[newY][newX] || map[newY][newX] == 0){
                continue;
            }
            count = dfs(newY, newX, count);
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        int K = Integer.parseInt(st.nextToken()); // 음식물 쓰레기 개수

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y-1][x-1] = 1;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    int count = dfs(i, j, 0);
                    res = Math.max(res, count);
                }
            }
        }

        System.out.println(res);
    }
}
