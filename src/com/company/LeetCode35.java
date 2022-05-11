package com.company;

public class LeetCode35 {
    private static int slo(int[] nums, int target) {
        int len = nums.length;
        if (target <= nums[0]) {
            return 0;
        }
        if (target > nums[len - 1]) {
            return len;
        }
        int index;
        int left = 0;
        int right = len - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                index = mid;
                //向前找
                while (index <= 1 && nums[index - 1] == target) {
                    index--;
                }
                return index;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3,5,6,7,8};
        System.out.println(slo(nums, 0));
    }
}
