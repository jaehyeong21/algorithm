import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class HashMapExample {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        HashMap<Integer, String> numToName = new HashMap<>();
        HashMap<String, Integer> nameToNum = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 포켓몬의 개수
        int M = Integer.parseInt(st.nextToken()); // 문제의 개수

        // 포켓몬 도감 초기화
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            numToName.put(i, name);  // 번호 -> 이름
            nameToNum.put(name, i);  // 이름 -> 번호
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String value = br.readLine();
            if (isNum(value)) {
                int num = Integer.parseInt(value);
                sb.append(numToName.get(num)).append("\n"); // 포켓몬 번호에 대응하는 포켓몬 이름
            } else {
                sb.append(nameToNum.get(value)).append("\n"); // 포켓몬 이름에 대응하는 포켓몬 번호
            }
        }

        System.out.println(sb.toString());
    }
    public static boolean isNum(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
