package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LeetCode88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }

        int c1 = 0;
        int c2 = 0;
        while (c1 < m && c2 < n) {
            if (nums1[c1 + c2] < nums2[c2]) {
                c1++;
                continue;
            }
            for (int j = m - 1 + c2; j >= c1 + c2; j--) {
                nums1[j + 1] = nums1[j];
            }
            nums1[c1 + c2] = nums2[c2];
            c2++;
        }

        while (c2 < n) {
            nums1[m + c2] = nums2[c2];
            c2++;
        }
    }

    private static void slo(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }

        int c1 = 0;
        int c2 = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        while (c1 < m && c2 < n) {
            if (nums1[c1] < nums2[c2]) {
                deque.addLast(nums1[c1]);
                c1++;
            } else {
                deque.addLast(nums2[c2]);
                c2++;
            }
        }

        while (c1 < m) {
            deque.addLast(nums1[c1++]);
        }
        while (c2 < n) {
            deque.addLast(nums2[c2++]);
        }

        int index = 0;
        while (index < n + m) {
            nums1[index++] = deque.removeFirst();
        }
    }

    public static void slo2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }
        while (p1 >= 0) {
            nums1[p--] = nums1[p1--];
        }
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        slo2(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
