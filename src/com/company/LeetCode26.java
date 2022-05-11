package com.company;

/**
 * 原地删除删除有序数组中的重复元素，使重复元素最多只有一个
 * 不定义新的数组空间
 * 快慢指针 滑动窗口
 */
public class LeetCode26 {
    private static int slo(int[] nums) {
        int len = nums.length;
        int slow = 0;
        int quick = 0;
        int index = 0;
        int res = 0;
        while (quick < len) {
            while (quick < len && nums[slow] == nums[quick]) {
                if (quick - slow < 1) {
                    nums[index++] = nums[quick];
                }
                quick++;
            }
            res += 1;

            slow = quick;
        }
        return res;
    }

    private static int slo2(int[] nums) {
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums2 = {1, 1, 1, 2, 2, 3};

        System.out.println(slo(nums));
        System.out.println(slo2(nums2));

    }

}
