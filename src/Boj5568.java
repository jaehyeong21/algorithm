//5568 카드 놓기
import java.util.HashSet;
import java.util.Scanner;

public class Boj5568 {
    static int n,k;
    static int[] cards, select; //select: 순열로 지정된 값
    static boolean[] used; //사용된 카드
    static HashSet<String> set= new HashSet<>();
    public static void permu(int len) {
        if(len == k){
            //선택한 숫자들을 합쳐서 새로운 정수 생성
            String s = "";
            for(int i=0; i<k; i++){
                s+= Integer.toString(select[i]);
            }
            //set 알아서 중복을 제거
            set.add(s);
            return;
        }

        for(int i=0; i<n; i++){
            if(!used[i]) {
                select[len] = cards[i];
                //백트래킹 지점 사용했던 값을 다시 되돌려놓는다.
                used[i] = true;
                permu(len+1);
                used[i] = false;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        cards = new int[n];
        used = new boolean[n];
        select = new int[k];
        for(int i=0; i<n; i++){
            cards[i] = sc.nextInt();
        }

        permu(0);
        System.out.println(set.size());

    }
}
