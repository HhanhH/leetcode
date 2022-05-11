package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode118 {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        for (int i = 2; i <= numRows; i++) {
            List<Integer> path = new ArrayList<>();
            path.add(1);
            List<Integer> pre = res.get(res.size() - 1);
            for (int j = 1; j < i - 1; j++) {
                path.add(pre.get(j - 1) + pre.get(j));
            }
            path.add(1);
            res.add(path);
        }
        return res;
    }
}
