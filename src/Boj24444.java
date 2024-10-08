import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj24444 {
    public static int vertex, edge, start;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static StringTokenizer st;
    public static boolean[] visited;
    public static int[] order;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        visited = new boolean[vertex + 1];
        order = new int[vertex + 1];

        for(int i = 0; i <= vertex; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 그래프 인접 리스트 정렬
        for(int i = 1; i <= vertex; i++){
            Collections.sort(graph.get(i));
        }

        bfs(start);

        // 각 정점의 방문 순서 출력
        for(int i = 1; i <= vertex; i++){
            System.out.println(order[i]);
        }
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        order[start] = ++count;

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int next : graph.get(node)){
                if(!visited[next]){
                    queue.offer(next);
                    visited[next] = true;
                    order[next] = ++count;
                }
            }
        }
    }
}
