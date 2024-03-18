import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student implements Comparable<Student> {
    String name;
    int kor;
    int eng;
    int math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Student o) {
        if (this.kor == o.kor) { // 1. 국어 점수가 같을 경우
            if (this.eng == o.eng) { // 2. 영어 점수가 같을 경우
                if (this.math == o.math) { // 3. 수학 점수가 같을 경우
                    return this.name.compareTo(o.name); // 4. 이름을 사전순으로 비교하여 반환
                } else { // 3. 수학 점수가 다를 경우
                    return Integer.compare(o.math, this.math); // 수학 점수가 감소하는 순서로 비교하여 반환
                }
            } else { // 2. 영어 점수가 다를 경우
                return Integer.compare(this.eng, o.eng); // 영어 점수가 증가하는 순서로 비교하여 반환
            }
        } else { // 1. 국어 점수가 다를 경우
            return Integer.compare(o.kor, this.kor); // 국어 점수가 감소하는 순서로 비교하여 반환
        }
    }
}

public class Boj10825 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // 개행문자 처리

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] strings = sc.nextLine().split(" ");
            String name = strings[0];
            int kor = Integer.parseInt(strings[1]);
            int eng = Integer.parseInt(strings[2]);
            int math = Integer.parseInt(strings[3]);
            students.add(new Student(name, kor, eng, math));
        }
        Collections.sort(students);

        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).name);
        }
    }
}
