import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1303_bfs {
    static int[][] location = {{1,0}, {-1,0}, {0, 1}, {0,-1}};
    static int N,M;
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        visited = new boolean[M][N];

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[M][N];

        for(int i = 0; i < M; i++){
            String line = br.readLine();
            for(int j = 0; j <N; j++){
                map[i][j] = line.charAt(j);
            }
        }
    }
}
