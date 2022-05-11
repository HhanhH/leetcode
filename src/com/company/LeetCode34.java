package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LeetCode34 {
    private static int[] slo(int nums[], int target) {
        int[] res = new int[2];
        if (nums.length == 0) {
            Arrays.fill(res, -1);
            return res;
        }

        if (nums.length == 1) {
            if (nums[0] == target)
                Arrays.fill(res, 0);
            else
                Arrays.fill(res, -1);
            return res;
        }

        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                res[0] = mid;
                res[1] = mid;
                while (res[0] >= 1 && nums[res[0] - 1] == target) {
                    res[0]--;
                }
                while (res[1] <= len - 2 && nums[res[1] + 1] == target) {
                    res[1]++;
                }
                return res;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        Arrays.fill(res, -1);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {9,9};
        int[] res = slo(nums, 9);
        System.out.println(Arrays.toString(res));
    }

}
