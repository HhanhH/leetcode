package com.company;


import java.util.HashMap;
import java.util.Map;

public class LeetCode220 {

    private static boolean slo(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i - k - 1 >= 0 && map.containsKey(getID(nums[i - k - 1], t))) {
                map.remove(getID(nums[i - k - 1], t));
            }

            //当前桶中已经存在元素，桶里的元素之差的绝对值一定是w
            if (map.containsKey(getID(nums[i], t)))
                return true;
            //判断左边桶有值时计算差的绝对值<=t,左边桶最多只可能存在一个值，多个值的话肯定已经return了，如上面的情况
            if (map.containsKey(getID(nums[i], t) - 1)
                    && Math.abs(map.get(getID(nums[i], t) - 1) - (long) nums[i]) <= t)
                return true;
            //判断右边桶有值时计算差的绝对值<=t,右边桶最多只可能存在一个值，多个值的话肯定已经return了，如上上面的情况
            if (map.containsKey(getID(nums[i], t) + 1)
                    && Math.abs(map.get(getID(nums[i], t) + 1) - (long) nums[i]) <= t)
                return true;

            map.put(getID(nums[i], t), (long) nums[i]);
        }
        return false;
    }

    private static long getID(long num, int t) {
        //正数时为了当num=t时能够放进第0个桶（t-0<=t）
        if (num >= 0) return (long) num / (t + 1);
            //负数时让-6~-1放入第-1个桶(|-6-(-1)|<=5)
        else return (long) ((num + 1) / (t + 1) - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 9, 1, 5, 9};
        System.out.println(slo(nums, 2, 3));
    }
}
