import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj24481 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    static ArrayList<ArrayList<Integer>> graph;
    static int[] depth;
    static boolean[] visited;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        int vertex = Integer.parseInt(st.nextToken()); // 정점
        int edge = Integer.parseInt(st.nextToken()); // 간선
        int startVertex = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(vertex + 1);
        depth = new int[vertex + 1];
        visited = new boolean[vertex + 1];

        Arrays.fill(depth, -1); // 깊이를 -1로 초기화하여 방문하지 않은 정점과 구분

        for (int i = 0; i < vertex + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int fromVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());

            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }

        for (int i = 1; i <= vertex; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(startVertex, 0);

        for (int i = 1; i <= vertex; i++) {
            sb.append(depth[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int vertex, int currentDepth) {
        visited[vertex] = true;
        depth[vertex] = currentDepth;

        for (int nextVertex : graph.get(vertex)) {
            if (!visited[nextVertex]) {
                dfs(nextVertex, currentDepth + 1);
            }
        }
    }
}