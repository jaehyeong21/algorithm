import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//Compartor compare(객체, 객체)

//Comparable compareTo(객체)


class Medal implements Comparable<Medal> {
    int num;
    int gold;
    int silver;
    int bronze;

    public Medal(int n, int g, int s, int b) {
        this.num = n;
        this.gold = g;
        this.silver = s;
        this.bronze = b;
    }

    @Override
    public int compareTo(Medal o) {
        if (this.gold == o.gold) {
            if (this.silver == o.silver) {
                return o.bronze - this.bronze; // 동메달 수를 기준으로 비교
            } else {
                return o.silver - this.silver; // 은메달 수를 기준으로 내림차순 정렬
            }
        } else {
            return o.gold - this.gold; // 금메달 수를 기준으로 내림차순 정렬
        }
    }
}

public class Boj8979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int k = Integer.parseInt(strings[1]);
        ArrayList<Medal> medals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            strings = sc.nextLine().split(" ");
            int num = Integer.parseInt(strings[0]);
            int g = Integer.parseInt(strings[1]);
            int s = Integer.parseInt(strings[2]);
            int b = Integer.parseInt(strings[3]);
            medals.add(new Medal(num, g, s, b));
        }
        Collections.sort(medals);

        // 특정 나라의 등수 찾기
        int rank = 1;
        int prevGold = medals.get(0).gold;
        int prevSilver = medals.get(0).silver;
        int prevBronze = medals.get(0).bronze;
        for (int i = 0; i < medals.size(); i++) {
            Medal current = medals.get(i);
            if (current.gold != prevGold || current.silver != prevSilver || current.bronze != prevBronze) {
                rank = i + 1;
                prevGold = current.gold;
                prevSilver = current.silver;
                prevBronze = current.bronze;
            }
            if (current.num == k) {
                System.out.println(rank);
                break;
            }
        }
    }
}
