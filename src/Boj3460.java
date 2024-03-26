import java.util.Scanner;

public class Boj3460 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int n;

        for(int i = 0; i < T; i++){
            n = sc.nextInt();
            String binary = Integer.toBinaryString(n);
            for(int j = binary.length() - 1; j >= 0; j--){
                if(binary.charAt(j) == '1'){
                    System.out.print(binary.length() - j - 1 + " ");
                }
            }
            System.out.println();
        }
    }
}

