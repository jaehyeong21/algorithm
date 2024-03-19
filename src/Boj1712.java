import java.util.Scanner;

public class Boj1712 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");

        int A = Integer.parseInt(str[0]); //고정비용
        int B = Integer.parseInt(str[1]); //가변비용
        int C = Integer.parseInt(str[2]); //노트북 가격

        if(B >= C){ //가변 비용이 노트북 가격보다 높으면 이익을 낼 수 없다.
            System.out.println("-1");
        }else{
            int res = C - B;
            int count = A / res + 1;
            System.out.println(count);
        }

    }
}
