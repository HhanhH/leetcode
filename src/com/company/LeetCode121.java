package com.company;

public class LeetCode121 {
    public static int maxProfit(int[] prices) {

        if (prices.length == 1) return 0;
        int price = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            price = Math.min(price, prices[i]);
            max = Math.max(max, prices[i] - price);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }
}
