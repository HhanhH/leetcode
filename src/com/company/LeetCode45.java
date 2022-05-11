package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class LeetCode45 {
    private static int slo(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();

        //先从第一个位置走
        queue.addLast(0);
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            //将queue中当前存在的元素个数去取完，这里的位置都是经过走count步到达的位置
            for (int i = 0; i < size; i++) {
                //取得当前位置
                int curPos = queue.removeFirst();
                //将从位置curPos可以走的情况都走一遍 nums[curPos],nums[curPos]-1,....1步
                //从大步到小步能找到最早到达终点的步数
                while (nums[curPos] > 0) {
                    //如果当前位置curPos+可以走的步数nums[curPos]已经走过，就不用再走了 因为前面需要的步数已经分别计算了，后面需要的步数是一样的
                    if (visited.contains(curPos + nums[curPos])) {
                        nums[curPos]--;
                        continue;
                    }

                    //如果当前位置curPos+走的步数nums[curPos]就到达了最后一个位置
                    if (curPos + nums[curPos] == nums.length - 1) return count + 1;
                    //记录走到了当前位置
                    visited.add(curPos + nums[curPos]);
                    //queue里面记录当前到达的位置
                    queue.addLast(curPos + nums[curPos]);
                    nums[curPos]--;
                }
            }
            //记录走的步数增加1
            count++;

        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(slo(nums));
    }
}

