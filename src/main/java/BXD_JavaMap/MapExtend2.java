package BXD_JavaMap;

import java.util.*;

public class MapExtend2 {
    public static void main(String[] args) {
        HashMap<String, List<student2>> company = new HashMap<String, List<student2>>();

        // 别忘了写泛型结构
        List<student2> xiaoBan = new ArrayList<student2>();
        List<student2> daBan = new ArrayList<student2>();
        company.put("xiaoBan", xiaoBan);
        company.put("daBan", daBan);

        xiaoBan.add(new student2("01","zhangsan"));
        xiaoBan.add(new student2("02","lisi"));
        daBan.add(new student2("03","wangwu"));
        daBan.add(new student2("04","Maliu"));

        Set<String> ks = company.keySet();
        Iterator<String> it = ks.iterator();

        while (it.hasNext()){
            String roomName = it.next();
            List<student2> stdLst = company.get(roomName);
            System.out.println(roomName);
            getStdInfo(stdLst);
        }
    }
    public static void getStdInfo(List<student2> lst){
        // 这时候你传的本来就是个集合不用再Keyset
        Iterator<student2> it = lst.iterator();
        while (it.hasNext()){
            student2 s = it.next();
            System.out.println(s);
        }
    }
}

class student2{
    String name;
    String id;
    public student2(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "student{" + "name='" + name + '\'' + ", id='" + id + '\'' + '}';
    }
}