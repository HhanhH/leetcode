package com.company;

import java.util.Arrays;

public class LeetCode66 {
    public int[] plusOne(int[] digits) {
        if (digits.length == 1 && digits[0] == 0) {
            digits[0]++;
            return digits;
        }

        int[] res = new int[digits.length + 1];
        for (int i = 0; i < digits.length; i++) {
            res[i + 1] = digits[i];
            if (i == digits.length - 1) {
                res[i + 1]++;
            }
        }
        for (int i = res.length - 1; i > 0; i--) {
            res[i - 1] += res[i] / 10;
            res[i] = res[i] % 10;
        }
        if (res[0] == 0) {
            return Arrays.copyOfRange(res, 1, res.length);
        } else {
            return res;
        }

    }

    public static void main(String[] args) {
        int[] nums = {9, 1};

        LeetCode66 leetCode66 = new LeetCode66();
        System.out.println(Arrays.toString(leetCode66.plusOne(nums)));
    }
}
