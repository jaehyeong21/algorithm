import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj24444try {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static boolean[] visited;
    public static int[] order;
    public static int count;
    public static int vertex, edge, start;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        for(int i = 0; i < vertex + 1; i++){
            graph.add(new ArrayList<>());
        }

        visited = new boolean[vertex + 1];
        order = new int[vertex + 1];

        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());
            graph.get(front).add(back);
            graph.get(back).add(front);
        }

        for(int i = 1; i < vertex + 1; i++){
            Collections.sort(graph.get(i));
        }
        count = 0;

        bfs(start);

        for(int i = 1; i < vertex + 1; i++){
            System.out.println(order[i]);
        }
    }

    public static void bfs(int vertex){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        visited[vertex] = true;
        order[vertex] = ++count;

        while(!queue.isEmpty()){
            int newVertex = queue.poll();
            for(int next : graph.get(newVertex)){
                if(!visited[next]){
                    queue.offer(next);
                    visited[next] = true;
                    order[next] = ++count;
                }
            }
        }
    }
}
