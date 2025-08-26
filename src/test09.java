import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class test09 {
    public static String Solution(int N){
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(N > 0){
            int a = 0;
            a = N % 2;
            stack.push(a);
            N = N / 2;
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        System.out.println(Solution(N));
    }
}
