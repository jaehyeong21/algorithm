import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj24479try1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int vertex,edge, startVertex;
    static int[] check;
    static int count;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        startVertex = Integer.parseInt(st.nextToken());

        check = new int[vertex + 1];

        for(int i = 0; i < vertex; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        count = 1;

        for(int i = 1; i <= graph.get(i).size(); i++){
            Collections.sort(graph.get(i));
        }

        dfs(startVertex);
    }

    static void dfs(int vertex){
        check[vertex] = count;

        if(check[vertex] == 0){
            count++;
            dfs(vertex);
        }
    }
}
