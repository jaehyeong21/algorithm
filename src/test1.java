import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class test1 {
    static int N, K;
    static int[] distances;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        distances = new int[100001];
        visited = new boolean[100001];

        System.out.println(bfs(N));
    }

    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == K) {
                return distances[current];
            }

            if (current - 1 >= 0 && !visited[current - 1]) {
                queue.offer(current - 1);
                visited[current - 1] = true;
                distances[current - 1] = distances[current] + 1;
            }

            if (current + 1 <= 100000 && !visited[current + 1]) {
                queue.offer(current + 1);
                visited[current + 1] = true;
                distances[current + 1] = distances[current] + 1;
            }

            if (current * 2 <= 100000 && !visited[current * 2]) {
                queue.offer(current * 2);
                visited[current * 2] = true;
                distances[current * 2] = distances[current] + 1;
            }
        }
        return -1;
    }
}
