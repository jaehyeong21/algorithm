import java.util.Scanner;
import java.util.Stack;

public class Boj10773 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = sc.nextInt();
        int[] arr = new int[n];
        sc.nextLine();
        int sum = 0;

        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            if(num > 0){
                stack.push(num);
            }else{
                stack.pop();
            }
        }

        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        System.out.println(sum);

    }
}
