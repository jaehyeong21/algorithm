import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj17086 {
    static int n,m;
    static boolean[][] visited;
    static int ans = 0;
    static int [][]map;
    static int[][] dist; // (i,j) 상어까지의 안전거리
    static int[][] dir = {{0,1}, {0,-1}, {-1,0}, {1,0},
                        {-1,-1}, {-1,1}, {1,-1}, {1,1}};

    static class Pair{
        int x;
        int y;
        int dist;
        public Pair(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    // bfs는 i,j 위치에 있는 안전거리를 반환
    public static int bfs(int i, int j){
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(i, j ,0));
        visited[i][j] = true;
        while(!que.isEmpty()){
            Pair p = que.poll();

            for(int d = 0; d < 8; d++){
                int nx = p.x + dir[d][0]; // (x,y)위치에서 갈 수 있는 8방향을 모두 탐색
                int ny = p.y + dir[d][1];
                // 범위를 벗어나거나 방문했던 곳이면 넘어간다.
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]){
                    continue;
                }
                if(map[nx][ny] == 1){
                    // 상어를 만났다.
                    return p.dist + 1;
                }
                visited[nx][ny] = true;
                que.offer(new Pair(nx,ny, p.dist + 1));
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            String[] temp = sc.nextLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int maxNum = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0){
                    visited = new boolean[n][m];
                    int dist = bfs(i,j);
                    maxNum = Math.max(maxNum, dist);
                }
            }
        }

        System.out.println(maxNum);
    }
}
