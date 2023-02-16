package LinkedListNArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    List<List<Integer>> ansList = new ArrayList<>();
    List<Integer>  subList = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        for (int i = 1; i <= n; i++) {
            subList.add(i);
        } // [1,2,3,4]

        for (int i = 0; i < subList.size(); i++) {
            int ele = subList.get(i);
            subList.remove(i);
            // recuresion function
            getCombine(k,ele);
            subList.add(i,ele);
        }
        return ansList;
    }

    private void getCombine( int k, int ele ){
        // base case
        if( subList.size() == k-1 ){
            List<Integer> aNewList = new ArrayList<>(subList);
            aNewList.add(ele);
            Collections.sort(aNewList);
            if(! ansList.contains(aNewList) )
                ansList.add(aNewList);
        }

        List<Integer> interList = new ArrayList<>();
        // rec case
        for (int i = 0; i < subList.size(); i++) {
             ele = subList.get(i);
            subList.remove(i);
            // recuresion function
            getCombine(k,ele);
            subList.add(i,ele);
        }
    }
}

