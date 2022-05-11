package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode60 {
    static int count = 0;
    static int N = 0;

    static List<List<Integer>> RES = new ArrayList<>();

    public static String permute(int n, int k) {

        int start = 0;
        int res = 1;
        int c = n - 1;
        N = n;
        while (c > 0) {
            res *= c;
            c--;
        }
        start = (k - 1) / res + 1;
        int mod = k - (start - 1) * res;
        List<Integer> path = new ArrayList<>();
        path.add(start);
        count = mod;
        component(path);
        StringBuilder builder = new StringBuilder();
        for (Integer integer : RES.get(0)) {
            builder.append(integer);
        }
        return builder.toString();
    }

    private static void component(List<Integer> path) {
        if (path.size() == N) {
            if (count == 1) {
                RES.add(new ArrayList<>(path));
            } else {
                count--;
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (path.contains(i)) {
                continue;
            }
            path.add(i);

            component(path);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(permute(3, 6));
    }
}
