package BXD_JavaMap;

import java.util.*;

// Hash map是无序的
public class Maps {
    public static void main(String[] args) {
    Map<String, String> map = new HashMap<String, String>();
    map.put("01","zhao");
    map.put("02","qian");
    map.put("03","sun");
    map.put("04","li");
    // map.put("04","wu"); 如果这时候再打一次相同的键，那么原来该键对应的值会被覆盖

    System.out.println("containsKey: " + map.containsKey("022"));
    System.out.println("Remove Key: " + map.remove("04"));
    System.out.println("Remove Key: " + map.get("04"));

    //可通过get方法返回值来判断一个键是否存在， 他可存空值或者空键. 但hash table并不能如此
    map.put(null,"haha");
    map.put("haha", null);

    //Collection获取map集合中所有的value
    Collection<String> coll = map.values();
    //方法1 Set集合 获取map集合中所有的key
    Set<String> st = map.keySet();
    // 有了st集合后， 就可以获取迭代器
    Iterator<String> it = st.iterator();

    System.out.println(coll);
    System.out.println(st);
    System.out.println(map);

        // map 集合的取出原理， 将map转成set集合，然后再通过迭代器取出
        while(it.hasNext()){
            String key = it.next();
            // 有了key就可通过map集合get方法获取其对应的值
            String value = map.get(key);
            System.out.println("key " + key + "value " + value);
        }

        // 方法2： 通过Entry 将Map集合中的映射关系取出，存入到Set集合中
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        //此时迭代器迭代的是Entry实例， 它包含一对键值对
        Iterator< Map.Entry<String, String> > it2 = entrySet.iterator();

        //在loop中建立一个个entry对象来取key和value
        while(it2.hasNext()){
            Map.Entry<String, String> me = it2.next();
            String key = me.getKey();
            String value = me.getValue();
            System.out.println("key " + key + " value " + value);
        }
    }
}
