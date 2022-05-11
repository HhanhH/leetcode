package com.company.two;

import java.util.HashSet;
import java.util.Set;

public class LeetCode137 {
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int setSum = 0;
        for (int i = 0; i < nums.length; i++) {
            b = (b ^ nums[i]) & ~a;
            a = (a ^ nums[i]) & ~b;
            sum += nums[i];
            if (set.add(nums[i]))
                setSum += nums[i];
        }
        return (3 * setSum - sum) / 2;


//        return b;
    }

    public static void main(String[] args) {
        System.out.println(1 ^ 1);
        System.out.println(1 ^ 2 ^ 1);
    }
}
