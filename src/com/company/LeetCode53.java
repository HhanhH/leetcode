package com.company;

public class LeetCode53 {
    private int slo(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            //
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(max, dp[i ]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-1};
        System.out.println(new LeetCode53().slo(nums));
    }
}
