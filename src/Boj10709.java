import java.util.*;
public class Boj10709 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(" ");

        int H = Integer.parseInt(strings[0]); //문자열을 int로 변환할 때 Integer로 변환
        int W = Integer.parseInt(strings[1]);
        //(int)는 double 에서 int 로 변환할 때 사용

        char[][] array = new char[H][W];

        for(int i = 0; i < H; i++){
            String line = sc.nextLine();
            for(int j = 0; j < W; j++){

            }
        }
    }
}
