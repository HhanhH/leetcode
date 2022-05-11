package com.company;

public class LeetCode75 {
    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) {
                swap(i, left++, nums);
            }
            if (nums[i] == 2) {
                swap(i--, right--,nums);
            }
        }
    }

    public static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] n = {1,2,0};
        sortColors(n);
    }
}
