import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj1021try {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        for(int i = 1; i <= N; i++){
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            int target = Integer.parseInt(st.nextToken());
            int index = 0;
            for (int number : deque) {
                if (number == target) {
                    break;
                }
                index++;
            }

            int leftToRight = index;
            int RightToLeft = deque.size() - index;

            if(leftToRight <= RightToLeft){
                for(int j = 0; j < leftToRight; j++){
                    deque.addLast(deque.pollFirst());
                }
                count = count + leftToRight;
            }else{
                for(int j = 0; j < RightToLeft; j++){
                    deque.addFirst(deque.pollLast());
                }
                count = count + RightToLeft;
            }

            deque.pollFirst();
        }

        System.out.println(count);
    }
}
