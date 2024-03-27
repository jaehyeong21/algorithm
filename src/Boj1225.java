import java.util.Scanner;

public class Boj1225 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");

        String A = str[0];
        String B = str[1];
        long res = 0; // 10000자리를 넘으면 안됨 고로 int타입을 벗어남

        for(int i = 0; i < A.length(); i++){
            int numA = Character.getNumericValue(A.charAt(i));
            for(int j = 0; j < B.length(); j++){
                int numB = Character.getNumericValue(B.charAt(j));
                res = res + (numA * numB);
            }
        }
        System.out.println(res);
    }
}
