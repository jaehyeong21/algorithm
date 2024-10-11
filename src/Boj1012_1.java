import java.io.*;
import java.util.StringTokenizer;

public class Boj1012_1 {

    static int m,n,k;
    static int[][] map; //배추밭
    static boolean[][] visited; //방문여부확인

    //상하좌우
    static int[][] di = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void dfs(int x, int y){

        visited[y][x] = true;

        //상하좌우로 이동
        for(int i=0; i<4; i++){
            //현재 위치(x,y)에서 움직일 새로운 방향(nx,ny)
            int nx = x + di[i][1];
            int ny = y + di[i][0];
            //범위가 벗어났는지 확인 + 배추가 심어졌는지 확인(예외처리)
            if(nx < 0 || ny < 0 || nx >=m || ny >= n || map[ny][nx]==0)
                continue;

            if(!visited[ny][nx]) {
                dfs(nx, ny);
            }

        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        while(t>0) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); //열
            n = Integer.parseInt(st.nextToken()); //행
            k = Integer.parseInt(st.nextToken()); //배추개수

            map = new int[n][m];
            visited = new boolean[n][m];

            //배추 심기
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                //x => 열,  y => 행
                map[y][x]=1;
            }


            //모든 좌표에 대해서 dfs 돌릴 수 있는지(연결 요소) 확인
            int cnt = 0;
            for(int y=0; y<n; y++) {
                for(int x=0; x<m; x++) {
                    if(map[y][x]==1 && !visited[y][x]) {
                        dfs(x,y);//배추흰지렁이가 1개 필요하다
                        cnt++;
                    }
                }
            }

            bw.write(cnt+"\n");
            bw.flush(); //버퍼비우기
            t--;
        }
    }
}
