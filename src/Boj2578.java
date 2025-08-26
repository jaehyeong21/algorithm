import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2578 {
    public static void bingoFunction(int num, int[][] board) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (num == board[i][j]) {
                    board[i][j] = 0;
                    return;
                }
            }
        }
    }

    public static int getBingoCount(int[][] board) {
        int count = 0;

        // 가로 줄 체크
        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (board[i][j] != 0) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) {
                count++;
            }
        }

        // 세로 줄 체크
        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (board[j][i] != 0) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) {
                count++;
            }
        }

        boolean isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (board[i][i] != 0) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) {
            count++;
        }

        isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (board[i][4 - i] != 0) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] board = new int[5][5];
        int callCount = 0;
        boolean bingo = false;

        // 빙고판 입력
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 사회자가 부른 숫자 입력 및 체크
        for (int i = 0; i < 5 && !bingo; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                callCount++;
                bingoFunction(num, board);
                // 빙고가 3개 이상이면 종료
                if (getBingoCount(board) >= 3) {
                    bingo = true;
                    System.out.println(callCount);
                    break;
                }
            }
        }
    }
}
