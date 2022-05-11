package com.company;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode54 {
    public List<Integer> slo(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> res = new ArrayList<>();

        int up = 0, down = m - 1, left = 0, right = n - 1;
        while (true) {
            for (int i = left; i <= right; i++) res.add(matrix[up][i]);
            if (++up > down) break;
            for (int i = up; i <= down; i++) res.add(matrix[i][right]);
            if (--right < left) break;
            for (int i = right; i >= left; i--) res.add(matrix[down][i]);
            if (--down < up) break;
            for (int i = down; i >= up; i--) res.add(matrix[i][left]);
            if (++left > right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(new LeetCode54().slo(nums).toString());
    }
}
