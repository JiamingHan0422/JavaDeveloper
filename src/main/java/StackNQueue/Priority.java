package StackNQueue;

// Java program to demonstrate working of
// comparator based priority queue constructor
import java.util.*;

public class Priority {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        PriorityQueue<Student> pq = new
                PriorityQueue<Student>(5, new StudentComparator());

        Student student1 = new Student("Nandini", 3.2, 'B');

        pq.add(student1);
        Student student2 = new Student("Anmol", 3.6,'A');
        pq.add(student2);
        Student student3 = new Student("Palak", 4.0,'A');
        pq.add(student3);
        Student student4 = new Student("Jiaming", 4.0,'A');
        pq.add(student4);
        Student student6 = new Student("Tom", 4.0,'A');
        pq.add(student6);
        Student student5 = new Student("Han", 4.0,'A');
        pq.add(student5);

        System.out.println("Students served in their priority order");

        while (!pq.isEmpty()) {
            System.out.println(pq.poll().getName());
        }
    }
}

// Comparator 里的compare（） 方法排序 除string 外任何
class StudentComparator implements Comparator<Student> {
//    @Override
//    public int compare(Student o1, Student o2) {
//        return o1.grade - o2.grade;
//    }

//    public int compare(Student o1, Student o2) {
//        return (int) (o1.cgpa - o2.cgpa);
//    }

    public int compare(Student o1, Student o2) {
        char[] chars1=o1.name.toCharArray();
        char[] chars2=o2.name.toCharArray();
        int i=0;
        while(i<chars1.length && i<chars2.length){
            if(chars1[i]>chars2[i]){
                return 1;
            }else if(chars1[i]<chars2[i]){
                return -1;
            }else{
                i++;
            }
        }
        if(i==chars1.length){  //o1到头
            return -1;
        }
        if(i== chars2.length){ //o2到头
            return 1;
        }
        return 0;
    }

}

class Student implements Comparable<Student>{
    public String name;
    public double cgpa;
    public char grade;
    public Student(String name, double cgpa, char grade) {
        this.name = name;
        this.cgpa = cgpa;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    // Comparable里的 compareTo（） 方法可让string按字典排序
    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

//    public int comparaTo(Student o){
//        return (int) (this.cgpa - o.cgpa);
//    }

//    public int comparaTo(Student o){
//        return (int) (this.grade - o.grade);
//    }
}
