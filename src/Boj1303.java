import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1303 {
    static int[][] location = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    static char[][] map;
    static boolean[][] visited;
    static int N,M;
    static int resultW = 0;
    static int resultB = 0;

    public static int dfs(int y, int x, char team){
        visited[y][x] = true;
        int count = 1;
        for(int i = 0; i < location.length; i++){
            int newY = y + location[i][0];
            int newX = x + location[i][1];
            if(newY < 0 || newX < 0 || newY >= M || newX >= N || visited[newY][newX] || map[newY][newX] != team){
                continue;
            }
            count += dfs(newY, newX, team);
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = line.charAt(j);
            }
        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    int count = dfs(i, j , map[i][j]);
                    if(map[i][j] == 'W'){
                        resultW = resultW + count * count;
                    }else{
                        resultB = resultB + count * count;
                    }
                }
            }
        }

        System.out.println(resultW + " " + resultB);
    }
}
