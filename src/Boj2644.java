import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2644 {

    static int n; // 사람 수
    static int start, end; // 촌수 계산 할 두 사람
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] dist; //거리배열

    public static int bfs(int start, int end) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;
        dist[start] = 0;

        while (!que.isEmpty()) {
            int node = que.poll();
            if (node == end) {
                return dist[node];
            }
            for (int i = 0; i < graph[node].size(); i++) {
                int v = graph[node].get(i);
                if (!visited[v]) {
                    visited[v] = true;
                    dist[v] = dist[node] + 1;
                    que.offer(v);
                }
            }
        }
        return -1; // 관계가 없을 경우
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        str = br.readLine().split(" ");
        start = Integer.parseInt(str[0]);
        end = Integer.parseInt(str[1]);

        int m = Integer.parseInt(br.readLine()); //관계 수 입력

        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        int result = bfs(start, end);
        System.out.println(result);
    }
}
