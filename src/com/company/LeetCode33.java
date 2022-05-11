package com.company;

public class LeetCode33 {
    private static int slo(int[] nums, int target) {
        int len = nums.length;
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = len - 1;
        //二分查找
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return mid;

            //从有序的一边比较容易判断target的范围
            if (nums[left] <= nums[mid]) {
                if (nums[left] == target) {
                    return left;
                }
                if (nums[left] < target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (nums[right] == target) return right;
                if (nums[mid] < target && target < nums[right])
                    left = mid + 1;

                else right = mid - 1;

            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 1, 2, 3, 4};
        System.out.println(slo(nums, 6));
    }
}
