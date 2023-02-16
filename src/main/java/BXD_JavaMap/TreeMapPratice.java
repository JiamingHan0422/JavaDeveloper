package BXD_JavaMap;

import java.util.*;

public class TreeMapPratice {
    public static String charCount (String str){

        char[] chs = str.toCharArray();
        // 必须传引用数据类型
        TreeMap<Character, Integer > tm = new TreeMap<Character, Integer >();
        int count=0;
        for(int i=0; i< chs.length; i++){
            if(! (chs[i] >= 'a' && chs[i] <= 'z' || chs[i] >= 'A' && chs[i] <= 'Z'))
                continue;
           //这个 get是在根据传入的key取值
           Integer val = tm.get(chs[i]);

           if(val != null)
                count = val;
           count ++;
           tm.put(chs[i], count);
           count =0;
        }
        System.out.println(tm);

        StringBuffer sb = new StringBuffer();
        Set<Map.Entry<Character,Integer>> entSet = tm.entrySet();
        Iterator<Map.Entry<Character,Integer>> itEs = entSet.iterator();

        while (itEs.hasNext()){
            Map.Entry<Character,Integer> mp = itEs.next();
            Character c = mp.getKey();
            Integer i = mp.getValue();

            sb.append(c + "(" + i +")" );
        }
        return sb.toString();
    }

    // TreeSet 自动排序
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        charCount(str);
    }
}
