import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10451 {
    static int[] permutation;
    static boolean[] visited;
    static int cycleCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine()); // 순열의 크기
            permutation = new int[n + 1];
            visited = new boolean[n + 1];
            cycleCount = 0;

            // 순열 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                permutation[i] = Integer.parseInt(st.nextToken());
            }

            // 사이클 찾기
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                    cycleCount++;
                }
            }
            // 결과 출력
            sb.append(cycleCount).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void dfs(int node) {
        visited[node] = true;
        int next = permutation[node];
        if (!visited[next]) {
            dfs(next);
        }
    }
}

