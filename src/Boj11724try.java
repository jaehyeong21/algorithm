import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj11724try {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int vertex, edge;
    public static StringTokenizer st;
    public static boolean visited[];
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int count;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        count = 0;

        for(int i = 0; i < vertex + 1; i++){
            graph.add(new ArrayList<>());
        }

        visited = new boolean[vertex + 1];

        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            graph.get(front).add(back);
            graph.get(back).add(front);
        }

        for(int i = 1; i <= vertex; i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void dfs(int vertex){
        visited[vertex] = true;
        for(int i = 0; i < graph.get(vertex).size(); i++){
            vertex = graph.get(vertex).get(i);
            if(!visited[vertex]){
                dfs(vertex);
            }
        }
    }
}
