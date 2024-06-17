
import java.util.Scanner;

public class DFS_Example {

    //인접 행렬(2차원 배열)
    static int vertex, edge;
    static int[][] graph;
    static boolean[] visited;


    public static void dfs(int start){
        System.out.print(start+"->");

        visited[start] = true;
        //start 노드와 연결된 노드에서 다시 dfs를 해야함
        for(int i=0; i<vertex; i++){
            //방문하지 않는 노드이면서 start노드와 연결되어있는 노드
            if(graph[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {

        /*5 5
        0 1
        1 2
        1 3
        2 3
        3 4*/
        Scanner sc=new Scanner(System.in);
        vertex = sc.nextInt();
        edge = sc.nextInt();

        graph = new int[vertex][vertex];
        visited = new boolean[vertex]; // 해당 노드를 방문했는지 체크
        for(int i=0; i<edge; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            //a 노드와 b 노드가 서로 연결되어있다.
            graph[a][b] = graph[b][a] = 1;
        }

        //dfs 호출
        dfs(0);


    }


}

