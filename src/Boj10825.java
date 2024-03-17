import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student implements Comparable<Student>{
    String name;
    int kor;
    int eng;
    int math;

    public Student(String name, int kor, int eng, int math){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Student o)
    {
        if(this.kor == o.kor){
            if(this.eng == o.eng){
                if(this.math == o.math){
                    return this.name.compareTo(o.name);
                }else{
                    return o.math - this.math;
                }
            }else{
                return this.eng - o.eng;
            }
        }else{
            return o.kor - this.kor;
        }
    }
}

public class Boj10825 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        ArrayList<Student> students = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String[] strings = sc.nextLine().split(" ");
            String name = strings[0];
            int kor = Integer.parseInt(strings[1]);
            int eng = Integer.parseInt(strings[2]);
            int math = Integer.parseInt(strings[3]);
            students.add(new Student(name,kor,eng,math));
        }
        Collections.sort(students);

        for(int i = 0; i < students.size(); i++){
            System.out.println(students.get(i).name);
        }
    }
}
