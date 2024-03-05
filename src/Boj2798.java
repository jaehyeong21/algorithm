import java.util.*;

public class Boj2798 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int total = 0;
        int Max = 0;
        String[] str = sc.nextLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int[] cards = new int[N];
        str = sc.nextLine().split(" ");
        for(int i = 0; i < N; i++){
            cards[i] = Integer.parseInt(str[i]);
        }

        // 3장의 조합
        for(int i = 0; i< N - 2; i++){
            for(int j = i+1; j < N-1; j++){
                for(int k = j + 1; k<N; k++){
                    total = cards[i] + cards[j] + cards[k];
                    if(total <= M){
                        Max = Math.max(Max, total);

                    }
                }
            }
        }
        System.out.print(Max);
    }
}
