import java.util.Scanner;

public class Boj6603 {


    //재귀 => 완전탐색문제
    //어떤 해답 => 모든 경우의수를 찾는 것
    //순열, 조합
    //재귀 => 그래프 구조
    static int k;
    static int[] nums;
    static boolean[] visited; //방문 여부
    static StringBuilder sb;
    static int[] order = new int[6]; // 로또 번호 순서(조합)
    public static void dfs(int depth, int idx){
        if(depth == 6) {
            for(int v: order) {
                sb.append(String.valueOf(v)+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=idx+1; i<k; i++) {
            if(!visited[i]){
                order[depth] = nums[i];
                //백트래킹 => dfs로 구현
                visited[i] = true; // 방문했다가
                dfs(depth+1, i); // dfs 탐색이 모두 끝난후에
                visited[i] = false; //방문 취소 => 그래야 이전 노드로 돌아와서 다른 노드선택
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        while(true){
            k = sc.nextInt();
            if(k==0) break;
            nums = new int[k];
            visited = new boolean[k];
            for(int i=0; i<k; i++){
                nums[i] = sc.nextInt();
            }
            sb = new StringBuilder();
            dfs(0,-1);
            System.out.println(sb.toString());
        }
    }



}