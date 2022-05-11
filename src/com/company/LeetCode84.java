package com.company;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 计算柱状图的面积
 * 单调递增栈，遇到比栈顶小的时候，栈顶循环出栈计算面积，当前元素入栈
 * 数组走完全部出栈，右边到头，左边到栈顶的距离
 * <p>
 * 哨兵机制减少特殊情况的考虑
 */
public class LeetCode84 {
    private static int getMaxArea(int[] nums) {
        int len11 = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] num2 = new int[len11 + 2];
        for (int i = 0; i < len11; i++) {
            num2[i + 1] = nums[i];
        }
        nums = num2;

        int area = 0;
        stack.addLast(0);
        int width = 0;
        int high = 0;
        for (int i = 1; i < nums.length; i++) {

            while (nums[stack.peekLast()] > nums[i]) {
                high = nums[stack.removeLast()];
                width = i - stack.peekLast() - 1;
                area = Math.max(area, width * high);
            }
            stack.addLast(i);
//            if (nums[stack.peekLast()] == nums[i]) {
//                continue;
//            } else {
//                stack.addLast(i);
//            }

        }
        return area;
    }

    public static void main(String[] args) {
        int[] nums3 = {2, 1, 5, 6, 2, 3};
        int ares = getMaxArea(nums3);
        System.out.println("最大面积：" + ares);
    }
}
