import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Boj24481_1 {

    // 인접리스트로 그래프 구현
    public static ArrayList<Integer>[] graph;
    // 노드를 방문했는지 확인하는 배열
    public static boolean[] visited;
    // 각 노드의 깊이를 저장하는 배열
    public static int[] depth;

    // DFS 메소드
    public static void dfs(int node, int d) {
        visited[node] = true; // 방문 체크
        depth[node] = d; // 깊이 저장

        // 다음 정점으로 dfs 호출 (내림차순 정렬 후 방문)
        for (int i = 0; i < graph[node].size(); i++) {
            int v = graph[node].get(i); // i번째에 있는 정점
            if (!visited[v]) {
                dfs(v, d + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정점의 개수
        int M = sc.nextInt(); // 간선의 개수
        int start = sc.nextInt(); // 시작 노드

        visited = new boolean[N + 1]; // 방문 여부 배열 초기화
        depth = new int[N + 1]; // 깊이 배열 초기화
        for (int i = 1; i <= N; i++) {
            depth[i] = -1; // 깊이 -1로 초기화
        }

        graph = new ArrayList[N + 1]; // 그래프 배열 초기화
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>(); // 각 정점을 위한 ArrayList 초기화
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt(); // 정점 u
            int v = sc.nextInt(); // 정점 v
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 시작
        dfs(start, 0);

        // 각 정점의 깊이 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(depth[i]);
        }

        sc.close();
    }
}
