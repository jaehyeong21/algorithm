import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj9742 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<String> permutations = new ArrayList<>();
    static boolean[] used;
    static char[] chars;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);

            String str = st.nextToken();
            int n = Integer.parseInt(st.nextToken());

            permutations.clear();
            chars = str.toCharArray(); //각 문자열 문자로 변환
            used = new boolean[chars.length];
            sb = new StringBuilder();

            generatePermutations(0, chars.length);

            if (n > permutations.size()) {
                System.out.println(str + " " + n + " = No permutation");
            } else {
                System.out.println(str + " " + n + " = " + permutations.get(n - 1));
            }
        }
    }

    private static void generatePermutations(int depth, int length) {
        if (depth == length) {
            permutations.add(sb.toString());
            return;
        }

        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                used[i] = true;
                sb.append(chars[i]);
                generatePermutations(depth + 1, length);
                sb.deleteCharAt(sb.length() - 1);
                used[i] = false;
            }
        }
    }
}
