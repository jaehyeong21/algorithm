import java.util.ArrayList;
import java.util.Scanner;

public class Boj2606 {

    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    public static int infectedCount = 0;

    public static void dfs(int node) {
        visited[node] = true;
        infectedCount++;

        for (int i = 0; i < graph[node].size(); i++) {
            int adjacent = graph[node].get(i);
            if (!visited[adjacent]) {
                dfs(adjacent);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 컴퓨터의 수
        int M = sc.nextInt(); // 직접 연결되어 있는 컴퓨터 쌍의 수

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1); // 1번 컴퓨터부터 바이러스 감염 시작

        System.out.println(infectedCount - 1); // 1번 컴퓨터를 제외한 감염된 컴퓨터의 수 출력

        sc.close();
    }
}
