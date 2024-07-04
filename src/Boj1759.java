
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1759 {

    static int l,c;
    static char[] s;
    static char[] pw;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static boolean check(char[] temp) {
        int ja = 0;
        int mo = 0;
        for (char ch : temp) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                mo++;
            } else {
                ja++;
            }
        }
        return ja >= 2 && mo >= 1;
    }

    public static void dfs(int idx, int depth) {

        if(depth == l) {
            if(!check(pw)) return; //암호조건을 만족하지 않음
            //암호조건을 만족하는 경우
            for(char ch: pw) {
                sb.append(ch);
            }
            sb.append("\n");
            return;
        }

        for(int i=idx+1; i<c; i++){
            if(!visited[i]) {
                //해당 알파벳을 사용
                visited[i] = true;
                pw[depth]= s[i];
                dfs(i, depth+1);
                //나중에 사용하기 위해 반납 (백트래킹 지점)
                visited[i] = false;

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        s = new char[c];
        visited = new boolean[c];
        pw = new char[l];

        for(int i=0; i<c; i++){
            s[i] = st.nextToken().charAt(0);
        }

        //정렬된 형태의 암호를 만들어야함
        Arrays.sort(s);
        dfs(-1,0);
        bw.write(sb.toString());
        bw.close();

    }
}