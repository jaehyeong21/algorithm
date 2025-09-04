package Boj5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj5397 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){

            String str = br.readLine();

            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for(char ch : str.toCharArray()){
                if(ch == '<'){
                    if(!left.isEmpty()){
                        right.push(left.pop());
                    }
                }else if(ch == '>'){
                    if(!right.isEmpty()){
                        left.push(right.pop());
                    }
                }else if(ch == '-'){
                    if(!left.isEmpty()){
                        left.pop();
                    }
                }else{
                    left.push(ch);
                }
            }

            StringBuilder sb = new StringBuilder();
            for(char c1 : left){
                sb.append(c1);
            }
            while(!right.isEmpty()){
                sb.append(right.pop());
            }

            System.out.println(sb.toString());
        }


    }
}
