import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;

public class Boj2667 {
    static int[][] location = {{-1,0}, {0,-1},{1,0},{0,1}};
    static boolean[][] visited;
    static int N;
    static int[][] map;
    static int houseCount;

    public static void dfs(int y, int x){
        visited[y][x] = true;
        houseCount++;

        for(int i = 0; i < location.length; i++){
            int newY = y + location[i][0];
            int newX = x + location[i][1];
            if (newY < 0 || newX < 0 || newY >= N || newX >= N || visited[newY][newX] || map[newY][newX] == 0) {
                continue;
            }

            if(!visited[newY][newX]){
                dfs(newY, newX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int count = 0;
        ArrayList<Integer> houseCounts = new ArrayList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    houseCount = 0;
                    dfs(i,j);
                    houseCounts.add(houseCount);
                    count++;
                }
            }
        }

        System.out.println(count); // 총 단지 수 출력
        Collections.sort(houseCounts); // 각 단지 내 집의 수를 오름차순으로 정렬
        for(int counts : houseCounts){
            System.out.println(counts); // 각 단지의 집 수 출력
        }
    }
}
