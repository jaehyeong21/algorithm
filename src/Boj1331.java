// 1331 나이트투어

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1331 {


    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1};
    static int SIZE = 6;

    public static int[] getPosition(String pos) {
        int x = pos.charAt(0) - 'A';
        int y = pos.charAt(1) - '1';
        return new int[]{x, y};
    }

    public static boolean check(int[] prev, int[] next) {

        for(int i = 0; i<8; i++) {
            int nx = prev[0] + dx[i];
            int ny = prev[1] + dy[i];

            if(next[0] == nx && next[1] == ny) return true; // 나이트가 움직일 수 있는 위치가 맞음
        }

        return false; //나이트가 움직일 수 있는 위치가 아니다.
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[SIZE][SIZE];
        int[] start = new int[2];
        int[] prev = new int[2];
//        int[] curr = new int[2];
        boolean valid = true;
        for(int i=0; i<36; i++){
            String pos = br.readLine();
            int[] curr = getPosition(pos);
            //여기에 들어가야할 조건? 이미 방문한 경우
            if(board[curr[1]][curr[0]] == 1) {
                valid = false;
                break;
            }
            //시작인 경우
            if(i==0) {
                start = curr;
            }
            //처음 위치가 아니면서 나이트의 이동경로가 아닌 경우는 invalid
            if(i!=0 && !check(prev, curr))  {
                valid = false;
                break;
            }

            board[curr[1]][curr[0]] = 1; // 방문한 값은 1, 방문하지 않은 값은 0
            prev = curr;
        }
        //마지막으로 갔을때 처음으로 돌아오는 가?
        if(valid && check(prev, start)) {
            System.out.println("Valid");
        }else {
            System.out.println("Invalid");
        }

    }
}
