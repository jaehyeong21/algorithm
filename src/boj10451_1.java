import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10451_1 {
    static int[] permutation;
    static boolean[] visited;
    static int Count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            permutation = new int[n+1];
            visited = new boolean[n+1];
            Count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++){
                permutation[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                    Count++;
                }
            }
        }
        System.out.print(sb.toString());
    }

    static void dfs(int node){
        visited[node] = true;
        int next = permutation[node];
        if(!visited[next]){
            dfs(next);
        }
    }
}
