package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 两个数组取k个数拼接最大值
 * 单调递减栈
 */
public class LeetCode321 {
    public static int[] getSlo(int[] nums1, int[] nums2, int k) {
        int[] preMax = null;
        for (int i = 0; i <= k; i++) {
            if (i > nums1.length || (k - i) > nums2.length) continue;
            int[] max1 = getMax(nums1, i);
            int[] max2 = getMax(nums2, k - i);
            int[] tmp = merge(max1, max2);
            if (greater(tmp, 0, preMax, 0)) {
                preMax = tmp;
            }
        }
        return preMax;
    }

    private static int[] getMax(int[] nums, int num) {
        if (num <= 0) {
            return null;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        while (index < nums.length) {
            while (index < nums.length && (stack.isEmpty() || stack.peekLast() >= nums[index]))
                stack.addLast(nums[index++]);
            if (index == nums.length) {
                break;
            }
            while (!stack.isEmpty() && stack.peekLast() < nums[index] && stack.size() + nums.length - index - 1 >= num) {
                stack.removeLast();
            }
            stack.addLast(nums[index++]);
        }
        int[] res = new int[num];
        for (int i = 0; i < num; i++) {
            res[i] = stack.pollFirst();
        }
        return res;
    }

    private static int[] merge(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return nums1 == null ? nums2 : nums1;
        int len1 = nums1.length;
        int len2 = nums2.length;

        int len = len1 + len2;
        int[] res = new int[len];
        int index = 0;

        int index1 = 0;
        int index2 = 0;
        while (index1 < len1 || index2 < len2) {
            if (greater(nums1, index1, nums2, index2)) {
                res[index++] = nums1[index1++];
            } else {
                res[index++] = nums2[index2++];
            }
        }
        return res;
    }

    private static boolean greater(int[] nums1, int index1, int[] nums2, int index2) {
        if (nums2 == null) return true;
        while (index1 < nums1.length && index2 < nums2.length && nums1[index1] == nums2[index2]) {
            index1++;
            index2++;
        }
        return index2 == nums2.length || (index1 != nums1.length && nums1[index1] > nums2[index2]);
    }

    public static void main(String[] args) {
        int[] nums1 = {8, 1, 8, 8, 6};
        int[] nums2 = {4};
//        int[] r = getMax(nums3, 3);
//        System.out.println(Arrays.toString(r));

        int[] res = getSlo(nums1, nums2, 2);
        System.out.println(Arrays.toString(res));
    }
}
