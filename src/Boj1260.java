import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1260 {

    static int n, m, v;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void bfs(int start) {
        visited[start] = true;
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);

        while (!que.isEmpty()) {
            int node = que.poll();
            sb.append(node + " ");
            for (int i = 0; i < graph[node].size(); i++) {
                int v = graph[node].get(i);
                if (!visited[v]) {
                    visited[v] = true;
                    que.offer(v);
                }
            }
        }
    }

    public static void dfs(int node) {
        visited[node] = true;
        sb.append(node + " ");
        for (int i = 0; i < graph[node].size(); i++) {
            int v = graph[node].get(i);
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        v = Integer.parseInt(str[2]);

        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        // 정렬 필요 (번호가 작은 노드부터 방문하기 위해)
        for (int i = 0; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        dfs(v);
        sb.append("\n");
        Arrays.fill(visited, false);  // 방문 배열 초기화
        bfs(v);
        System.out.println(sb.toString());
    }
}
