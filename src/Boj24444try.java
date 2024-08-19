import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj24444try {
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
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        bfs(start);

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
            int node = queue.poll(); // 정점 하나 꺼냄
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
