package com.company;

import java.util.ArrayList;
import java.util.List;

public class LeetCode89 {
    public static List<Integer> grayCode(int n) {

        List<Integer> res = new ArrayList<>();
        res.add(0);
        if (n == 0) return res;
        res.add(1);
        if (n == 1) return res;

        int c = 2;
        while (c <= n) {
            int size = res.size() - 1;
            List<Integer> path = new ArrayList<>(size + 1);
            for (; size >= 0; size--) {
                path.add(res.get(size) + (int) Math.pow(2, c - 1));
            }
            for (Integer i : path) {
                res.add(i);
            }
            c++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(5).toString());
    }
}
