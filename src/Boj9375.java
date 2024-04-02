import java.util.*;

public class Boj9375 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());

        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(sc.nextLine());

            Map<String, Integer> clothesMap = new HashMap<>(); // 의상 종류와 수를 저장할 Map

            for(int i = 0; i < n; i++){
                String[] input = sc.nextLine().split(" ");
                String type = input[1]; // 의상의 종류
                clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1); // 의상 종류에 해당하는 수를 증가시킴
            }

            int combination = 1;
            for(int count : clothesMap.values()){
                combination *= (count + 1); // 각 의상 종류의 수에 1을 더한 값을 모두 곱함
            }
            // 알몸이 아닌 상태에서 몇일까지 가능한지 물어보기 때문에 -1 해야함
            combination -= 1;

            System.out.println(combination);
        }
    }
}
