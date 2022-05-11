package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode119 {
    public List<Integer> getRow(int numRows) {

        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        for (int i = 2; i <= numRows + 1; i++) {
            List<Integer> path = new ArrayList<>();
            path.add(1);
            for (int j = 1; j < i - 1; j++) {
                path.add(pre.get(j - 1) + pre.get(j));
            }
            path.add(1);
            pre = path;
        }
        return pre;
    }
}
