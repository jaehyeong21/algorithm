import java.util.Scanner;

public class Boj25304 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine()); //상품 가격
        int n = Integer.parseInt(sc.nextLine()); // 산 물건의 총 개수
        int total = 0; //구매한 총 금액

        for(int i = 0; i < n; i++){
            String[] strings = sc.nextLine().split(" ");
            int a = Integer.parseInt(strings[0]); //물건의 가격
            int b = Integer.parseInt(strings[1]); //물건의 개수
            total += (a * b);
        }

        if(total == x){
            System.out.print("Yes");
        }else{
            System.out.print("No");
        }
    }
}
