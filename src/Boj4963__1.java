import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj4963__1 {
    static int[][] map;
    static boolean[][] visited;
    static int w,h;
    static int[][] location = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    public static void dfs(int y, int x){
        visited[y][x] = true;
        for(int i = 0; i < location.length; i++){
            int hy = y + location[i][0];
            int wx = x + location[i][1];
            if (hy < 0 || wx < 0 || hy >= h || wx >= w || map[hy][wx] == 0) {
                continue;
            }
            if(!visited[hy][wx]){
                dfs(hy, wx);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if((w == 0 && h == 0)){
                break;
            }
            map = new int[h][w];
            visited = new boolean[h][w];

            for (int y = 0; y < h; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < w; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for(int y = 0; y < h; y++){
                for(int x = 0; x < w; x++){
                    if(!visited[y][x] && map[y][x] == 1){
                        dfs(y, x);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
