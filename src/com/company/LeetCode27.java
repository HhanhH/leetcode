package com.company;

/**
 * 原地删除删除有序数组中的重复元素，使重复元素最多只有两个
 * 不定义新的数组空间
 * 快慢指针 滑动窗口
 */
public class LeetCode27 {
    private static int slo(int[] nums, int val) {
        int right = nums.length - 1;
        int left = 0;
        int res = 0;
        int tmp = 0;
        while (left < right && left < nums.length - 1) {
            while (nums[left] == val && right > left) {
                //交换left和right的值
                tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                right--;
            }
            if (left == right && nums[left] == val) {
                continue;
            }
            left++;
            res++;
        }
        if (left == right && nums[left] != val) {
            res++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {3, 3};
        System.out.println(slo(nums, 3));

    }

}
