import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1260__try {
    static int vertex, edge, start;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    // DFS 함수 구현
    public static void dfs(int start){
        // 현재 노드 방문 처리
        visited[start] = true;
        System.out.print(start + " "); // 방문한 노드 출력

        // 현재 노드에서 인접한 노드 탐색
        for (int i = 0; i < graph.get(start).size(); i++) {
            int next = graph.get(start).get(i);
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs(int start){
        visited[start] = true;
        System.out.print(start + " ");
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int i = 0; i < graph.get(current).size(); i++) {
                int next = graph.get(current).get(i);
                if(!visited[next]) {
                    visited[next] = true;
                    System.out.print(next + " ");
                    queue.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken()); // 정점 수
        edge = Integer.parseInt(st.nextToken());   // 간선 수
        start = Integer.parseInt(st.nextToken());  // 시작 정점

        visited = new boolean[vertex + 1]; // 방문 여부 체크 배열 초기화

        // 그래프 초기화
        for (int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            // 양방향 그래프이므로 두 방향으로 연결
            graph.get(front).add(back);
            graph.get(back).add(front);
        }

        // 그래프의 각 리스트 정렬 (정점 번호가 작은 것부터 탐색하기 위해)
        for (int i = 1; i <= vertex; i++) {
            Collections.sort(graph.get(i));
        }

        // DFS 탐색 시작
        dfs(start);
        Arrays.fill(visited, false); // 방문 배열 초기화
        bfs(start);
    }
}
