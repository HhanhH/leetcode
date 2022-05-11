package com.company;

public class LeetCode55 {

    public boolean slo(int[] nums) {
        int[] jump = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            jump[i] = i + nums[i];
        }
        int index = 0;
        int max_jump = 0;
        while (index < nums.length && index <= max_jump) {
            if (jump[index] >max_jump){
                max_jump = jump[index];
            }
            index++;
        }
        if (index == nums.length){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode55 l  = new LeetCode55();
        int[] nums = {2,3,2,1,0,2,1};
        System.out.println(l.slo(nums));
        int[] nums1 = {2,4,2,1,0,2,1};
        System.out.println(l.slo(nums1));

    }
}
