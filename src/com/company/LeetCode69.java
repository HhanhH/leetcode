package com.company;

public class LeetCode69 {
    public static int mySqrt(int x) {
        int left = 1;
        int right = x;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(16));
    }
}
