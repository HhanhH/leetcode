package com.company;

/**
 * 原地删除删除有序数组中的重复元素，使重复元素最多只有两个
 * 不定义新的数组空间
 * 快慢指针 滑动窗口
 */
public class LeetCode80 {
    private static int slo(int[] nums) {
        int len = nums.length;
        int slow = 0;
        int quick = 0;
        int index = 0;
        int res = 0;
        while (quick < len) {
            while (quick < len && nums[slow] == nums[quick]) {
                if (quick - slow < 2) {
                    nums[index++] = nums[quick];
                }
                quick++;
            }
            if (quick - slow >= 2) {
                res += 2;
            } else {
                res += quick - slow;
            }
            slow = quick;
        }
        return res;
    }



    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(slo(nums));

    }

}
