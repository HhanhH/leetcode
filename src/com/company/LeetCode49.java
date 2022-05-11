package com.company;

import java.util.*;

public class LeetCode49 {


    private static List<List<String>> slo(List<String> str) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : str) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String st = new String(chars);
            if (map.get(st)==null){
                map.put(st,new ArrayList<>());
            }
           map.get(st).add(s);
        }
        for (List<String> item : map.values()) {
            res.add(new ArrayList<>(item));
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> str = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        List<List<String>> res = slo(str);
        for (List<String> item : res) {
            System.out.println(item.toString());
        }

    }
}
