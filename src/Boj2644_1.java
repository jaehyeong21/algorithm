import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj2644_1 {
    static int n;
    static int start, end;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];

        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        str = br.readLine().split(" ");
        start = Integer.parseInt(str[0]);
        end = Integer.parseInt(str[1]);

        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++){
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            graph[a].add(b);
            graph[b].add(a);
        }
    }
}
