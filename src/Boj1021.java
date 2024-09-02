import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1021 {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 큐의 크기
        int M = Integer.parseInt(st.nextToken()); // 뽑아내려는 수의 개수

        for(int i = 1; i <= N; i++){
            q.offer(i);
        }

        st = new StringTokenizer(br.readLine());

        int total = 0;

        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());

            int index = q.indexOf(num);
            int qSize = q.size() / 2;

            if(index <= qSize){
                // 왼쪽으로
                for(int j = 0; j < index; j++){
                    q.offerLast(q.pollFirst());
                    total++;
                }
            } else{
                //오른쪽으로
                for(int j = 0; j < q.size() - index; j++){
                    q.offerFirst(q.pollLast());
                    total++;
                }
            }
            q.pollFirst();
        }
        System.out.println(total);
    }
}
