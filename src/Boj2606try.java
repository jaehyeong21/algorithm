import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj2606try {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int count;
    public static int vertex, edge, start;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        edge = Integer.parseInt(st.nextToken());

        count = 0;
        start = 1;

        for(int i = 0; i < vertex + 1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            graph.get(front).add(back);
            graph.get(back).add(front);
        }

        visited = new boolean[vertex + 1];

        dfs(start);

        System.out.println(count - 1);
    }

    public static void dfs(int vertex){
        visited[vertex] = true;
        count++;

        for(int i = 0; i < graph.get(vertex).size(); i++){
            int newVertex = graph.get(vertex).get(i);
            if(!visited[newVertex]){
                dfs(newVertex);
            }
        }

    }
}
