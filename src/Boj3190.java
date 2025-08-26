import java.io.*;
import java.util.*;

public class Boj3190 {
    static int n, k, l;
    static int[][] board;
    static Map<Integer, String> directions = new HashMap<>();
    static int[] dx = {0, 1, 0, -1}; // 동, 남, 서, 북
    static int[] dy = {1, 0, -1, 0};

    public static int simulate() {
        Queue<int[]> snake = new LinkedList<>();
        snake.offer(new int[]{0, 0}); // 뱀의 초기 위치
        int x = 0, y = 0, dir = 0, time = 0; // 초기 상태
        board[0][0] = 2; // 뱀이 있는 곳은 2로 표시

        while (true) {
            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 벽 또는 자기 자신과 충돌
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 2) {
                break;
            }

            // 이동
            if (board[nx][ny] == 1) { // 사과가 있는 경우
                board[nx][ny] = 2; // 뱀의 몸길이를 늘림
                snake.offer(new int[]{nx, ny});
            } else { // 사과가 없는 경우
                board[nx][ny] = 2;
                snake.offer(new int[]{nx, ny});
                int[] tail = snake.poll(); // 꼬리를 줄임
                board[tail[0]][tail[1]] = 0;
            }

            // 방향 전환
            if (directions.containsKey(time)) {
                String turn = directions.get(time);
                if (turn.equals("L")) {
                    dir = (dir + 3) % 4; // 왼쪽 회전
                } else if (turn.equals("D")) {
                    dir = (dir + 1) % 4; // 오른쪽 회전
                }
            }

            x = nx;
            y = ny;
        }
        return time;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        board = new int[n][n];

        // 사과 위치 입력
        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]) - 1;
            int y = Integer.parseInt(input[1]) - 1;
            board[x][y] = 1; // 사과 위치는 1로 표시
        }

        // 방향 변환 정보 입력
        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            String[] input = br.readLine().split(" ");
            int time = Integer.parseInt(input[0]);
            String dir = input[1];
            directions.put(time, dir);
        }

        System.out.println(simulate());
    }
}
