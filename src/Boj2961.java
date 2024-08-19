import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2961 {
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] ingredients = new int[N][2];

        for(int i = 0; i < N; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(str.nextToken());
            int B = Integer.parseInt(str.nextToken());
            ingredients[i][0] = S;
            ingredients[i][1] = B;
        }

        dfs(ingredients, 0, 1, 0, 0);
        System.out.println(result);
    }

    public static void dfs(int[][] ingredients, int index, int sour, int bitter, int count) {
        if (index == ingredients.length) {
            if (count > 0) { // 적어도 하나의 재료가 선택된 경우
                result = Math.min(result, Math.abs(sour - bitter));
            }
            return;
        }

        // 현재 재료를 선택하지 않는 경우
        dfs(ingredients, index + 1, sour, bitter, count);

        // 현재 재료를 선택하는 경우
        dfs(ingredients, index + 1, sour * ingredients[index][0], bitter + ingredients[index][1], count + 1);
    }
}
