import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj10828 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }else if(command.equals("pop")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
            }else if(command.equals("top")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }
            }else if(command.equals("size")){
                System.out.println(stack.size());
            }else if(command.equals("empty")){
                System.out.println(stack.isEmpty() ? 1 : 0);
            }
        }
    }
}
