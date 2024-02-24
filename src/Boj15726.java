import java.util.*;

public class Boj15726 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //1. 문장으로 입력 받기
        String str = sc.nextLine();
        //2. 띄워쓰기 기준으로 쪼개기
        String[] strings = str.split(" "); //{"32" , "16", "8"}
        //3. 데이터 변환
        double A = Integer.parseInt(strings[0]);
        double B = Integer.parseInt(strings[1]);
        double C = Integer.parseInt(strings[2]);
        //4. 로직구현
        int result1 = (int)(A * B / C);
        int result2 = (int)(A / B * C);

        //비교하는 다양한 방법들
        //5. 답 출력
        System.out.print(Math.max(result1, result2));

        /*System.out.println((result1 > result2) ? result1 : result2);

        if(result1 > result2) System.out.print(result1);
        else System.out.print(result2);*/

        //6. 테스트 케이스 확인하기
        //6-1 주어진 테스트 케이스 확인
        //6-2 내가 만든 테스트 케이스 확인 (16 16 8 => 16 * 16/8 , 16/16*8)
    }
}
