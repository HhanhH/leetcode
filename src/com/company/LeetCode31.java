package com.company;

import java.util.Arrays;

/**
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * <p>
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * <p>
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * <p>
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * <p>
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode31 {
    private static void slo(int[] nums) {
        //
        int len = nums.length;
        if (len <= 1) {
            return;
        }

        int index = len - 1;
        //从后向前找到递增失败的位置
        while (index >= 1 && nums[index] <= nums[index - 1]) {
            index--;
        }
        //全部递增，4,3,3,2,1,则重新从小到大排序
        if (index == 0) {
            Arrays.sort(nums, 0, len);
            return;
        }
        if (index == len - 1) {
            exch(nums, index - 1, index);
            return;
        }
        //向后找到最小大于index-位置数的位置
        int excindex = index;
        while (excindex < len && nums[index - 1] < nums[excindex]) {
            excindex++;
        }
        //交换index-1位置和excindex-1
        exch(nums, index - 1, excindex - 1);
        Arrays.sort(nums, index, len);

    }

    private static void exch(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] nums1 = {5, 4, 3, 2, 1};
        int[] nums2 = {1, 2, 5, 4, 3, 2, 1};
        slo(nums);
        System.out.println(Arrays.toString(nums));
        slo(nums1);
        System.out.println(Arrays.toString(nums1));
        slo(nums2);
        System.out.println(Arrays.toString(nums2));

    }
}
