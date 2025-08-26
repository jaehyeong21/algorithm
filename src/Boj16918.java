import java.io.*;
import java.util.*;

public class Boj16918 {

    static int r, c, n;
    static char[][] board;
    static int[][] time; // 폭탄 설치 시간을 저장
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    // 폭탄 설치 함수
    public static void plantBombs(int currentTime) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == '.') { // 빈칸에 폭탄 설치
                    board[i][j] = 'O';
                    time[i][j] = currentTime;
                }
            }
        }
    }

    // 폭탄 폭발 함수
    public static void explodeBombs(int currentTime) {
        char[][] newBoard = new char[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(newBoard[i], '.'); // 폭발 후 빈칸으로 초기화
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O' && time[i][j] + 3 == currentTime) {
                    newBoard[i][j] = '.'; // 폭탄이 있는 칸 폭발
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                            newBoard[nx][ny] = '.'; // 폭탄 영향 확산
                        }
                    }
                } else if (board[i][j] == 'O') {
                    newBoard[i][j] = 'O'; // 다른 폭탄은 유지
                }
            }
        }
        board = newBoard; // 보드 갱신
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        r = Integer.parseInt(str[0]);
        c = Integer.parseInt(str[1]);
        n = Integer.parseInt(str[2]);

        board = new char[r][c];
        time = new int[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'O') {
                    time[i][j] = 0; // 초기 폭탄 설치 시간
                }
            }
        }

        int currentTime = 1; // 시뮬레이션 시간 시작
        while (currentTime <= n) {
            if (currentTime % 2 == 0) {
                plantBombs(currentTime); // 짝수 초에 폭탄 설치
            } else if (currentTime > 1) {
                explodeBombs(currentTime); // 홀수 초에 폭발
            }
            currentTime++;
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
