import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2644_bfs {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] dist; // 촌수를 저장할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 받기
        int vertex = Integer.parseInt(br.readLine()); // 사람 수
        visited = new boolean[vertex + 1]; // 방문 체크 배열
        dist = new int[vertex + 1]; // 거리(촌수) 배열

        // 비교할 두 사람 입력 받기
        st = new StringTokenizer(br.readLine());
        int front = Integer.parseInt(st.nextToken()); // 앞 사람
        int back = Integer.parseInt(st.nextToken()); // 뒷 사람

        int edge = Integer.parseInt(br.readLine()); // 관계 수

        // 그래프 초기화
        for (int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<>());
        }

        // 관계 입력 (간선 연결)
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // BFS로 촌수 계산
        int result = bfs(front, back);

        // 결과 출력
        System.out.println(result);
    }

    // BFS 함수 구현
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

            // 인접한 사람들 탐색
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    dist[neighbor] = dist[node] + 1;
                    que.offer(neighbor);
                }
            }
        }
        return -1; // 관계가 없을 경우
    }
}
