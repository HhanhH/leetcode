package com.company;


import java.util.Arrays;

/**
 * 90度旋转图像
 */
public class LeetCode48 {

    private static void slo(int[][] nums) {
        if (nums.length == 1) {
            return;
        }
        int gap = nums.length - 1;
        int start = 0;
        while (gap > 0) {
            //左上 横坐标不变：start,纵坐标递增：start+i
            //右上：横坐标递增：start+i,纵坐标不变：start+gap
            //右下：横坐标不变：start+gap,纵坐标递减：start+gap-i
            //左下：横坐标递减：start+gap-i，纵坐标不变start
            for (int i = 0; i < gap; i++) {
                //暂存左上
                int tmp = nums[start][start + i];
                //左上 = 左下 ↑
                nums[start][start + i] = nums[start+gap-i][start];
                //左下=右下  ←
                nums[start + gap - i][start] = nums[start + gap][start + gap - i];
                //右下 = 右上 ↓
                nums[start + gap][start + gap - i] = nums[start + i][start + gap];
                // 右上 = 左上 →
                nums[start + i][start + gap] = tmp;

            }
            start++;
            gap -= 2;
        }

    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
        slo(nums);
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }

    }
}
