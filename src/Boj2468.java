import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2468 {
    static int[][] location = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    static boolean[][] visited;
    static int N;
    static int[][] map;
    static int count = 0;

    public static void dfs(int y, int x, int h){
        visited[y][x] = true;
        for(int i = 0; i < location.length; i++){
            int newY = y + location[i][0];
            int newX = x + location[i][1];

            if(newY < 0 || newX < 0 || newY >= N || newX >= N || visited[newY][newX]) {
                continue;
            }
            if(map[newY][newX] > h){
                dfs(newY, newX, h);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        int maxHeight = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > maxHeight){
                    maxHeight = map[i][j]; // 지도에서 가장 높은 값
                }
            }
        }

        int maxSafeZones = 0;

        for(int h = 0; h <= maxHeight; h++){
            visited = new boolean[N][N];
            int safeZoneCount = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] > h && !visited[i][j]){
                        dfs(i, j , h);
                        safeZoneCount++;
                    }
                }
            }
            maxSafeZones = Math.max(maxSafeZones, safeZoneCount);
        }
        System.out.println(maxSafeZones);
    }
}
