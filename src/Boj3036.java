import java.util.Scanner;

public class Boj3036 {

    public static int add(int a, int b){//유클리드 호제법?
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] str = sc.nextLine().split(" ");

        int first = Integer.parseInt(str[0]);

        for(int i = 1; i < N; i++){ //두 번째 수 부터 시작
            int num = Integer.parseInt(str[i]);
            int res = add(first, num);

            System.out.println((first / res) + "/" + (num/res));
        }
    }
}
