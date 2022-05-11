package com.company;

import java.util.Arrays;

/**
 * 利用通排序算法，桶间距离大于桶内距离，计算当前桶的最小值到上一个不为空的桶的最大值的间距
 * 最少需要len-1桶
 * 桶排序
 */
public class LeetCode164 {
    private static int getMaxGap(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        //找到最大值和最小值
        int min = Integer.MAX_VALUE;
        int max = -1;

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        //桶排序算法
        //计算最大平均间隔
        int interval = (int) Math.ceil((double) (max - min) / (len - 1));
        //设置len-1个桶
        int[] bucketMax = new int[len - 1];
        int[] bucketMin = new int[len - 1];
        Arrays.fill(bucketMax, -1);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        //找到每个桶的最大值和最小值
        for (int i = 0; i < len; i++) {
            //最大最小值不用放
            if (nums[i] == min || nums[i] == max) {
                continue;
            }
            int ID = (nums[i] - min) / interval;
            bucketMax[ID] = Math.max(bucketMax[ID], nums[i]);
            bucketMin[ID] = Math.min(bucketMin[ID], nums[i]);
        }
        int maxGap = -1;
        int preMax = min;
        for (int i = 0; i < len - 1; i++) {
            if (bucketMax[i] == -1) continue;
            maxGap = Math.max(maxGap, bucketMin[i] - preMax);
            preMax = bucketMax[i];
        }
        maxGap = Math.max(maxGap, max - preMax);
        return maxGap;

    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 1, 15};
        System.out.println(getMaxGap(nums));
    }
}
