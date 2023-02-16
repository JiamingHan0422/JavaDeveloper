package BXD_JavaMap;

import java.util.*;

public class MapExtend {
    public static void main(String[] args) {
        HashMap<String, String> xiaoBan = new HashMap<String, String>();
        xiaoBan.put("han jiaming","401");
        xiaoBan.put("ha jiaming","402");
        xiaoBan.put("ga jiaming","403");

        HashMap<String, String> daBan = new HashMap<String, String>();
        daBan.put("han jiaming","403");
        daBan.put("ha gaming","404");
        daBan.put("ga gagaming","405");

        // 嵌套集合
        HashMap<String, HashMap<String, String >> company = new HashMap<String, HashMap<String, String >>();
        company.put("xiaoBan", xiaoBan);
        company.put("daBan", daBan);

        Set<Map.Entry<String,HashMap<String, String>>> entryset = company.entrySet();
        Iterator<Map.Entry<String,HashMap<String, String>>> ites = entryset.iterator();
        // 若用KeySet做则  Iterator<String> ites = company.keySet().iterator();

        while(ites.hasNext()){
            Map.Entry<String,HashMap<String, String>> ety = ites.next();
            String roomName= ety.getKey();
            HashMap<String, String> room = ety.getValue();

            // 若用KeySet做则
            // String roomName= ites.next();
            // HashMap<String, String> room = company.get(roomName);
            getStudentInfo(room);
        }
    }

    //班里面的同学
    public static void getStudentInfo(HashMap<String, String> hm){
        Set<Map.Entry<String,String>> entryset = hm.entrySet();
        Iterator<Map.Entry<String,String>> ites = entryset.iterator();
        // 若用KeySet做则：Iterator<String> ites = company.keySet().iterator();

        while(ites.hasNext()){
            Map.Entry<String,String> ety = ites.next();
            String stdName= ety.getKey();
            String id = ety.getValue();

            // 若用KeySet做则
            //String stdName= it.next();
            //String id = hm.get(stdName);
            System.out.println(stdName +" : "+ id);
        }
    }
}
