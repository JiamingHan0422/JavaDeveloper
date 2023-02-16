package BXD_JavaMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapPartice {
    public static void main(String[] args) {
        HashMap<Student, String> hm = new HashMap<Student, String>();
        hm.put(new Student("han",26), "CA");
        hm.put(new Student("han",25), "CA");
        hm.put(new Student("han",24), "CA");
        hm.put(new Student("han",23), "CA");

        //法1：keySet 用集合取出
        Set<Student> keySet = hm.keySet();
        Iterator<Student> it = keySet.iterator();

        while(it.hasNext()){
            Student std = it.next();
            // 有了key就可通过map集合get方法获取其对应的值
            String location = hm.get(std);
            System.out.println("Student " + std + "location " + location);
        }

        //法2：用entrySet取出 步骤 1.定义hashmap 2.定义entryset 3。定义迭代器
        Set<Map.Entry<Student,String>> entrySet = hm.entrySet();
        Iterator<Map.Entry<Student,String>> itES =  entrySet.iterator();

        while(itES.hasNext()){
            Map.Entry<Student, String> stdMp = itES.next();
            Student std = stdMp.getKey();
            String location = stdMp.getValue();
            System.out.println("Student " + std + "location " + location);
        }
    }
}

class Student implements Comparable<Student>{
    private String name;
    private int age;

    Student(String name, int age){
        this.age = age;
        this.name = name;
    }
    @Override
    public int compareTo(Student s) {
        int num = new Integer(this.age).compareTo(new Integer(s.age));
        if(num == 0)
            return this.name.compareTo((s.name));
        return num;
    }

    public int hashCode(){
        return name.hashCode() + age*34;
    }

    public boolean equals(Object obj){
        // 若类型不是 Student 则报错
        if(!(obj instanceof Student))
            throw new ClassCastException(" Cast not match !");
        Student s = (Student) obj;
        // 仅当 name和age都对上号的时候才equal
        return this.name.equals(s.name) && this.age == s.age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

}