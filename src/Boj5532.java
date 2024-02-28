import java.util.*;

public class Boj5532 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int L = Integer.parseInt(sc.nextLine()); //방학 총 일수
        int A = Integer.parseInt(sc.nextLine()); // 국어 총 페이지
        int B = Integer.parseInt(sc.nextLine()); // 수학 총 페이지
        int C = Integer.parseInt(sc.nextLine()); // 풀 수 있는 국어 페이지
        int D = Integer.parseInt(sc.nextLine()); // 풀 수 있는 수학 페이지

        A = (A % C > 0) ? A/C+1 : A/C;
        B = (B % D > 0) ? B/D+1 : B/D;

        int result = (Math.max(A,B));

        System.out.println(L - result);

    }
}
