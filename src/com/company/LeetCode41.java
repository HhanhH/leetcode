package com.company;

/**
 * 找到最小没出现的正整数
 * <p>
 * 核心思路：最小一个对应位置没有出现对应数字的就是最小没出现的正整数
 * <p>
 * 1 -1 3 4 5 6
 * 正确为
 * 1 2 3 4 5 6
 * 则2为最小未出现的正整数
 */
public class LeetCode41 {
    //桶排序交换
    private static int slo1(int[] nums) {
        //将负数更为较大的数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0)
                nums[i] = nums.length + 1;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);

        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private static void swap(int[] nums, int s, int t) {
        int tmp = nums[s];
        nums[s] = nums[t];
        nums[t] = tmp;
    }

    private static int hashSlo(int[] nums) {
        //将负数变为length+1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0)
                nums[i] = nums.length + 1;
        }
        //将nums[i]-1位置的数变为负数
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) <= nums.length)
                //当前还有负数的原因肯定是因为之前的步骤将之变为负数的，所以要去绝对值再加上-
                nums[Math.abs(nums[i]) - 1] = nums[Math.abs(nums[i]) - 1]>0?-nums[Math.abs(nums[i]) - 1]:nums[Math.abs(nums[i]) - 1];
        }
        //找到第一个为负数的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                return i + 1;
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = {7, 8, 9, 11, 12};
//        System.out.println(slo1(nums));
        int[] nums1 = {3, 4, -1, 1};
        System.out.println(hashSlo(nums1));
    }
}
