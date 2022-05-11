package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode59 {
    public int[][] slo(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        int up = 0, down = n - 1, left = 0, right = n - 1;
        while (true) {
            for (int i = left; i <= right; i++) res[up][i] = count++;
            if (++up > down) break;
            for (int i = up; i <= down; i++) res[i][right] = count++;
            if (--right < left) break;
            for (int i = right; i >= left; i--) res[down][i] = count++;
            if (--down < up) break;
            for (int i = down; i >= up; i--) res[i][left] = count++;
            if (++left > right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new LeetCode59().slo(4);
        for (int[] item : nums)
            System.out.println(Arrays.toString(item));
    }
}
