import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1012__1 {
    static int[][] di = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    static int m,n,k;
    static int map[][];
    static boolean visited[][];

    public static void dfs(int x, int y){
        visited[y][x] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + di[i][1];
            int ny = y + di[i][0];
            // 범위가 벗어났는지 확인 + 배추가 심어졌는지 확인(예외 처리)
            if(nx < 0 || ny < 0 || nx >= m || ny >= n || map[ny][nx] == 0)
                continue;
            if(!visited[ny][nx]){
                dfs(nx,ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int count = 0;
            m = Integer.parseInt(st.nextToken()); // 배추 밭 가로길이
            n = Integer.parseInt(st.nextToken()); // 배추 밭 세로길이
            k = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수

            map = new int[n][m];
            visited = new boolean[n][m];

            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            for(int y = 0; y < n; y++){
                for(int x = 0; x < m; x++){
                    if(map[y][x]== 1 && !visited[y][x]){
                        dfs(x,y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
