package Boj1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1018 {
    static char[][] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int repaintW = checkBoard(i, j, 'W');
                int repaintB = checkBoard(i, j, 'B');
                result = Math.min(result, Math.min(repaintW, repaintB));
            }
        }

        System.out.println(result);
    }

    public static int checkBoard(int x, int y, char start) {
        int count = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                char expected = ((i - x) + (j - y)) % 2 == 0
                        ? start
                        : (start == 'W' ? 'B' : 'W');

                if (arr[i][j] != expected) {
                    count++;
                }
            }
        }

        return count;
    }
}
