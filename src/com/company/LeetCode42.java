package com.company;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 接雨水
 *
 * 长为 index - peekLast -1
 * 高为 min(index,peekLast) - cur
 * |666666|
 * ||55555|
 * |||4444|
 * ||||333|
 * |||||22|
 * ||||||1|
 */

public class LeetCode42 {
    private static int slo(int[] nums) {

        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        int res = 0;
        while (i < nums.length) {
            while (i < nums.length && (stack.isEmpty() || nums[stack.peekLast()] >= nums[i])) {
                stack.addLast(i++);
            }
            if (i == nums.length) {
                break;
            }

            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
                int cur = stack.removeLast();

                if (stack.isEmpty()) {
                    break;
                }
                int w = i - stack.peekLast() - 1;
                int h = Math.min(nums[i], nums[stack.peekLast()])-nums[cur];
                res += w * h;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(slo(nums));
    }
}
