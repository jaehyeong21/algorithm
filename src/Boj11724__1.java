import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj11724__1 {
    static int edge, vertex;
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void dfs(int vertex){
        visited[vertex] = true;

        for(int i = 0; i < graph.get(vertex).size(); i++){
            int newvertex = graph.get(vertex).get(i);
            if(!visited[newvertex]){
                dfs(newvertex);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        visited = new boolean[vertex+1];

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

        int count = 0;

        for(int i = 1; i <= vertex; i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }
}
