package com.company;

public class LeetCode81 {
    public static boolean search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target;
        }

        int len = nums.length;
        int left = 0;
        int right = len - 1;

        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }

            while (left<=mid&&nums[left]==nums[mid]){
                left++;
            }
            if (left>mid)
                continue;

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] > target) {

                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        System.out.println(search(nums, 2));
    }
}
