import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '(') {
                // 여는 괄호일 경우, 막대기의 시작 또는 레이저의 시작일 수 있으니 스택에 push
                stack.push(c);
            } else {
                // 닫는 괄호일 경우
                stack.pop(); // 일단 스택에서 하나를 pop
                if (line.charAt(i - 1) == '(') {
                    // 바로 앞이 '('면 레이저
                    result += stack.size(); // 현재 스택에 쌓인 막대기들만큼 잘려나감
                } else {
                    // 그렇지 않으면 막대기의 끝
                    result += 1; // 막대기 하나가 끝났으니 1을 더함
                }
            }
        }

        System.out.println(result);
    }
}
