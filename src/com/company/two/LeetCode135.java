package com.company.two;

import java.util.*;

public class LeetCode135 {
    public static int candy(int[] ratings) {

        Map<Integer, List<Integer>> indexMap = new TreeMap<>();

        Map<Integer, Integer> candyCount = new HashMap<>();

        for (int i = 0; i < ratings.length; i++) {
            List<Integer> list = indexMap.get(ratings[i]);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(i);
            indexMap.put(ratings[i], list);
        }

        boolean first = true;

        int count = 0;



        for (Map.Entry<Integer, List<Integer>> entry : indexMap.entrySet()) {
            if (first) {
                for (Integer index : entry.getValue()) {
                    candyCount.put(index, 1);
                    count++;
                }
                first = !first;
            } else {
                for (Integer index : entry.getValue()) {
                    int num = 1;
                    if (index > 0 && ratings[index - 1] < ratings[index])
                        num = Math.max(num, candyCount.getOrDefault(index - 1, 0) + 1);
                    if (index < ratings.length - 1 && ratings[index] > ratings[index + 1])
                        num = Math.max(num, candyCount.getOrDefault(index + 1, 0) + 1);
                    candyCount.put(index, num);
                    count += num;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {29,51,87,87,72,12};
        System.out.println(candy(nums));
    }
}
