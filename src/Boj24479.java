import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj24479 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기 위한 BufferedReader
    static StringTokenizer st; // 입력된 문자열을 공백 기준으로 나누기 위한 StringTokenizer
    static StringBuilder sb = new StringBuilder(); // 출력 결과를 효율적으로 모으기 위한 StringBuilder

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 그래프를 인접 리스트 형태로 저장할 ArrayList
    static int[] check; // 각 정점의 방문 순서를 저장할 배열
    static int count; // 현재 방문 순서를 저장할 변수

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine()); // 첫 번째 줄 입력을 받음

        int vertex = Integer.parseInt(st.nextToken()); // 정점의 개수를 입력받음
        int edge = Integer.parseInt(st.nextToken()); // 간선의 개수를 입력받음
        int startVertex = Integer.parseInt(st.nextToken()); // 시작 정점을 입력받음

        // 방문한 정점을 기록할 배열을 정점의 개수 + 1 크기로 생성 (1부터 사용)
        check = new int[vertex + 1];

        // 그래프의 각 정점을 위한 리스트 초기화
        for (int i = 0; i < vertex + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보를 입력받아 그래프를 구성
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int fromVertex = Integer.parseInt(st.nextToken()); // 시작 정점을 입력받음
            int toVertex = Integer.parseInt(st.nextToken()); // 끝 정점을 입력받음

            // 무방향 그래프이므로 양쪽으로 간선을 추가
            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }

        // 각 정점의 인접 리스트를 오름차순으로 정렬
        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        // DFS 방문 순서를 기록할 count 초기화
        count = 1;

        // 시작 정점에서 DFS를 시작
        dfs(startVertex);

        // 각 정점의 방문 순서를 출력하기 위해 StringBuilder에 추가
        for (int i = 1; i < check.length; i++) {
            sb.append(check[i]).append("\n");
        }
        System.out.println(sb); // 결과를 출력
    }

    // DFS 메서드 정의
    private static void dfs(int vertex) {
        check[vertex] = count; // 현재 정점의 방문 순서를 기록

        // 현재 정점의 인접 정점을 순회
        for (int i = 0; i < graph.get(vertex).size(); i++) {
            int newVertex = graph.get(vertex).get(i); // 다음으로 방문할 정점

            // 방문하지 않은 정점인 경우에만 방문
            if (check[newVertex] == 0) {
                count++; // 방문 순서를 증가
                dfs(newVertex); // 재귀 호출을 통해 DFS 수행
            }
        }
    }
}
