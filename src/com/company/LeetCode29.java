package com.company;

public class LeetCode29 {
    public static int divide(int dividend, int divisor) {
        int truncste = 0;
        int absdiv = Math.abs(dividend);
        int absdi = Math.abs(divisor);

        while (absdiv  >= absdi) {
            truncste++;
            absdiv -= absdi;
        }
        if ((dividend ^ divisor) < 0) {
            return -(truncste);
        }
        return truncste;

    }

    public static void main(String[] args) {
        System.out.println(-1 ^ -1);
        System.out.println(-(-1));
        System.out.println(divide(-1, -1));
    }
}
