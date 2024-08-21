import java.util.Scanner;
import java.util.Stack;

public class Boj9012 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < T; i++){
            String input = sc.nextLine();
            System.out.println(result(input) ? "YES" : "NO");
        }
    }
    public static boolean result(String input){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);

            if(c == '('){
                stack.push(c);
            }else if(c == ')'){
                if(stack.empty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
