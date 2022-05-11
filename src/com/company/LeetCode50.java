package com.company;

import javax.swing.*;

public class LeetCode50 {
    private static double slo(double x, int n) {
        long N = n;
        if (n < 0) {
            N = -N;
            x = 1.0 / x;
        }

        double res = 1.0;
        double curProduct = x;
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                res *= curProduct;
            }
            curProduct *= curProduct;
        }
        return  res;
    }

    public static void main(String[] args) {
        System.out.println(slo(2,-2));
    }
}
