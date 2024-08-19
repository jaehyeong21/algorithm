import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Boj1389 {
    static int n, m;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] distances;

    public static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        distances = new int[n + 1];
        visited = new boolean[n + 1];

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    distances[next] = distances[node] + 1;
                    q.offer(next);
                }
            }
        }

        int totalDistance = 0;
        for (int i = 1; i <= n; i++) {
            totalDistance += distances[i];
        }
        return totalDistance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            graph[u].add(v);
            graph[v].add(u);
        }

        int minDistance = Integer.MAX_VALUE;
        int person = -1;

        for (int i = 1; i <= n; i++) {
            int distance = bfs(i);
            if (distance < minDistance) {
                minDistance = distance;
                person = i;
            }
        }

        System.out.println(person);
    }
}
