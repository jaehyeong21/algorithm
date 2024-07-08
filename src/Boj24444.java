import java.io.*;
import java.util.*;

public class Boj24444 {
    static int n, m, r;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] order;
    static int cnt = 0;

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start); // Queue 삽입
        visited[start] = true;
        order[start] = ++cnt;

        while (!queue.isEmpty()) {
            int node = queue.poll(); // 정점 하나 꺼냄
            for (int next : graph[node]) { // 현재 정점 node의 인접 정점들을 순회
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    order[next] = ++cnt; // 정점이 방문된 순서를 기록
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        r = Integer.parseInt(input[2]);

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        } //graph는 [[], [], [], [], [], []]로 초기화

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            graph[u].add(v); // 정점 u에 정점 v 추가
            graph[v].add(u); // 정점 v에 정점 u 추가 (양방향 그래프 연결)
        }

        // 정점 번호가 작은 순서대로 방문하기 위해 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[n + 1];
        order = new int[n + 1];

        bfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.print(sb.toString());
    }
}
