package com.company.two;

public class LeetCode134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int oilSum = 0;
            int index = i;
            while (oilSum + gas[index] - cost[index] >= 0) {
                oilSum = oilSum + gas[index] - cost[index];
                index = (index + 1) % gas.length;
                if (index == i)
                    return i;
            }
            if (index < i)//index->i已经尝试过不能走环，i->index也不能走环，所以直接结束
                return -1;
            i = index;  //i->index中间的肯定无法成环，如果中间有能够成环的，那么从i开始也能成环，因为i->x的油量剩余>=0,从x开始都能走环，从i开始也一定能走环

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cos = {1, 2, 5, 1, 8};
        canCompleteCircuit(gas, cos);
    }
}
