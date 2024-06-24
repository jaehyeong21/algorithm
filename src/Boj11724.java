import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj11724 {

    //인접리스트 => ArrayList

    //인접리스트로 그래프 구현
    //public static ArrayList<ArrayList<Integer>> temp;
    public static ArrayList<Integer> graph[];
    //노드를 방문했는지 확인하는 배열
    public static boolean visited[];

    public static int N,M; //정점, 간선, 시작노드


    public static void dfs(int node) {

        visited[node]=true; //방문체크

        //그 다음 정점으로 dfs 호출
        for(int i=0; i<graph[node].size(); i++){
            int v = graph[node].get(i); //i번째에 있는 정점
            if(!visited[v]) {
                dfs(v);
            }
        }
    }
    //100글자 => Buffer(임시 저장소) 에 50글자씩 =>String 형태로
//Scanner => 자료형을 구별해준다 => 정규식(느려)
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        //Scanner sc= new Scanner(System.in);
        N = Integer.parseInt(st.nextToken()); // String => int
        M = Integer.parseInt(st.nextToken());


        visited = new boolean[N+1];
        graph = new ArrayList[N+1]; //배열을 초기화 => ArrayList 초기화
        for(int i=0; i<=N; i++) {
            //i는 정점 //new ArrayList의 역할?? i 정점과 연결된 정점들을 저장하는 리스트
            //ArrayList는 배열과 다르게 크기가 동적이다. (넣는 만큼 크기가 결정된다)
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            //정점들을 연결
            graph[u].add(v);
            graph[v].add(u);

        }

        int count = 0; //연결 요소의 개수를 세는 변수
        for(int i=1; i<=N; i++) {
            //방문하지 않은 정점에 대해서 dfs를 돈다 (방문하지 않았다 = 새로운 연결 요소를 찾았다)
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }
        //int + 문자열 => 문자열
        //bufferedwriter에서 int를 출력하면 아스키코드 값이 출력되므로 문자열로 변환해서 출력한다.
        bw.write(String.valueOf(count));
        bw.flush(); //버퍼비우기
        bf.close(); //리소스 반납
        bw.close();
    }
}
