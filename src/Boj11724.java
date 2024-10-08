import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj11724 {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static boolean visited[];
    public static int vertex, edge;
    public static int count;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        visited = new boolean[vertex + 1];

        for(int i = 0; i <= vertex + 1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        count = 0;

        for(int i = 1; i <= vertex; i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void dfs(int vertex){
        visited[vertex] = true;

        for(int i = 0; i < graph.get(vertex).size(); i++){
            int newvertex = graph.get(vertex).get(i);
            if(!visited[newvertex]){
                dfs(newvertex);
            }
        }
    }
}
