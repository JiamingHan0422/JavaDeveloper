package Leetcode;

import java.util.Scanner;
import java.util.TreeMap;

import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;
import static java.lang.System.in;

public class HMLeetCode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        String inputStr = in.nextLine().toUpperCase();
        char input = in.next().charAt(0);
        char[] chArr = inputStr.toCharArray();

        TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();
        Integer valsUp = 0;
        for (int i = 0; i < chArr.length; i++) {
            if (!(chArr[i] >= 'a' && chArr[i] <= 'z' || chArr[i] >= 'A' && chArr[i] <= 'Z'))
                continue;
            int count = 0;
            Integer val = tm.get(chArr[i]);

            if (val != null)
                count = val;

            count++;
            tm.put(chArr[i], count);
        }

        valsUp = tm.get(toUpperCase(input));

        if(valsUp == null)
            valsUp =0;
        System.out.print(valsUp);
    }

//    public static Integer getOutput(String inputStr, Character input) {
//        char[] chArr = inputStr.toCharArray();
//        TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();
//        Integer valsUp = null , valsLow = null;
//        for (int i = 0; i < chArr.length; i++) {
//            if (!(chArr[i] >= 'a' && chArr[i] <= 'z' || chArr[i] >= 'A' && chArr[i] <= 'Z'))
//                continue;
//            int count = 0;
//            Integer val = tm.get(chArr[i]);
//
//            if (val != null)
//                count = val;
//            count++;
//            tm.put(chArr[i], count);
//
//
//            valsUp = tm.get(toUpperCase(input));
//            valsLow = tm.get(toLowerCase(input));
//        }
//        return valsUp + valsLow;
//    }


}
