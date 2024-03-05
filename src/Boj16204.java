import java.util.*;

public class Boj16204 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N; //카드 개수
        int M; // 앞면에 O가 적힌 카드 개수
        int K; // 뒷면O개수
        int O;
        int X;
        int front_X; // 카드 앞 x개수
        int back_X; // 카드 뒤 x개수
        int result;

        String str = sc.nextLine();
        String[] strings = str.split(" ");

        N = Integer.parseInt(strings[0]);
        M = Integer.parseInt(strings[1]);
        K = Integer.parseInt(strings[2]);

        front_X = N - M;
        back_X = N - K;

        if(front_X > back_X){
            X = back_X;
        }else if(back_X > front_X){
            X = front_X;
        }else{
            X = back_X;
        }

        if(M > K){
            O = K;
        }else if(K > M){
            O = M;
        }else{
            O = M;
        }

        result = O + X;
        System.out.println(result);
    }
}
