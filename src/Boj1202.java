import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1202 {
    // 보석 클래스 정의
    static class Jewel implements Comparable<Jewel> {
        int weight;
        int price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewel other) {
            // 무게 오름차순, 가격 내림차순으로 정렬
            if (this.weight == other.weight) {
                return other.price - this.price;
            }
            return this.weight - other.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수

        // 보석 리스트와 가방 리스트 생성
        ArrayList<Jewel> jewels = new ArrayList<>();
        ArrayList<Integer> bags = new ArrayList<>();

        // 보석 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(weight, price));
        }

        // 가방 정보 입력
        for (int i = 0; i < K; i++) {
            int capacity = Integer.parseInt(br.readLine());
            bags.add(capacity);
        }

        // 보석과 가방 정렬
        Collections.sort(jewels); // Jewel 클래스의 compareTo에 따라 정렬
        Collections.sort(bags); // 가방의 무게는 오름차순 정렬

        // 우선순위 큐를 사용해 가격이 높은 보석을 담기
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long maxValue = 0;
        int jewelIndex = 0;

        // 각 가방에 대해 가능한 보석을 선택
        for (int bag : bags) {
            // 현재 가방에 담을 수 있는 모든 보석을 우선순위 큐에 추가
            while (jewelIndex < N && jewels.get(jewelIndex).weight <= bag) {
                pq.add(jewels.get(jewelIndex).price);
                jewelIndex++;
            }
            // 가장 비싼 보석을 선택
            if (!pq.isEmpty()) {
                maxValue += pq.poll();
            }
        }

        // 결과 출력
        System.out.println(maxValue);
    }
}
