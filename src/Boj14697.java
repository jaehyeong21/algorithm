import java.util.*;

public class Boj14697 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");

        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        int C = Integer.parseInt(str[2]);
        int N = Integer.parseInt(str[3]); //총 학생 수
        int res = 0;

        for(int i = 0; i <= N/A; i++){ //모든 경우의 수 계산 브루트포스 알고리즘
            for(int j = 0; j <= N/B; j++) {
                for (int z = 0; z <= N / C; z++) {
                    if((A * i + B * j + C * z) == N){
                        res = 1;
                        break;
                    }
                }
            }
        }

        System.out.println(res);
    }
}
