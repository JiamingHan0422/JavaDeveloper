package BXD_JavaMap;

import java.util.*;

// HashMap是基于哈希表+数组来实现的，而TreeMap是基于红黑树实现的
//HashMap需要key对象明确定义了hashCode()和equals()这两个方法 且可以调整初始容量大小和扩容. HashMap比TreeMap的性能更高
// TreeMap没有大小设置选项, 但好处是 HashMap是无序的，而TreeMap是有序的。 TreeMap适用于按自然顺序或自定义顺序遍历键的场景
public class Map2 {
    public static void main(String[] args) {
        // 此时 Treemap里就要加一个 StuNameComparator 对象 来完成比较
        TreeMap<Student, String> tm = new TreeMap<Student, String>( new StuNameComparator());
        tm.put(new Student("han",26), "CA");
        tm.put(new Student("jan",25), "CA");
        tm.put(new Student("zan",24), "CA");
        tm.put(new Student("wan",23), "CA");

        Set<Map.Entry<Student,String>> entrySet2 = tm.entrySet();

        Iterator<Map.Entry<Student,String>> itES = entrySet2.iterator();

        while(itES.hasNext()){
            Map.Entry<Student, String> stdMp = itES.next();
            Student std = stdMp.getKey();
            String location = stdMp.getValue();
            System.out.println("Student " + std + "location " + location);
        }
    }
}
// 设置一个 Comparator 使他按照学生姓名排序
class StuNameComparator implements Comparator<Student>{
    public int compare (Student s1, Student s2){
        //若返回“负数”，意味着“x比y小”；返回“零”，意味着“x等于y”；返回“正数”，意味着“x大于y”。
        //表示先比名字 再比 年龄
         int num= s1.getName().compareTo(s2.getName());
         if (num == 0)
             return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
         return num;
    }
}
