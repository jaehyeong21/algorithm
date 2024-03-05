import java.util.*;
import java.util.regex.Pattern;

public class Boj2897 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(" ");

        int r = Integer.parseInt(strings[0]); // 행
        int c = Integer.parseInt(strings[1]); // 열
        int result[] = new int[5]; //결과 값 배열

        char[][] array = new char[r][c]; // 2차원 배열로 행과 열 입력 받아서 할당

        for(int i = 0; i < r; i++){
            String line = sc.nextLine();
            for(int j = 0; j < c; j++){
                array[i][j] = line.charAt(j); //charAt는 String로 저장된 문자열 중에서 한 글자만 택해서 char 타입으로 변환해줌
            }
        }

        for(int i = 0; i < r-1; i++){
            for(int j = 0; j < c-1; j++){
                if(array[i][j] == '#' || array[i][j+1] == '#' || array[i+1][j] == '#' || array[i+1][j+1] == '#'){
                    continue;
                }
                int X = 0;
                if(array[i][j] == 'X'){
                    X++;
                }
                if(array[i][j+1] == 'X'){
                    X++;
                }
                if(array[i+1][j] == 'X'){
                    X++;
                }
                if(array[i+1][j+1] == 'X'){
                    X++;
                }
                    result[X]++;
                }
            }
        for(int i = 0; i < 5; i++){
            System.out.println(result[i]);
        }

    }
}

