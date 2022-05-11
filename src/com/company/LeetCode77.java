package com.company;

import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {
    static List<List<Integer>> res = new ArrayList<>();
    static int N = 0;

    public static List<List<Integer>> combine(int n, int k) {
        if (n == k) {
            List list = new ArrayList();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            res.add(list);
            return res;
        }

        N = n;
        comp(1, k, new ArrayList<>());
        return res;

    }

    private static void comp(int start, int count, List<Integer> path) {
        if (count == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= N; i++) {
            path.add(i);
            comp(i + 1, count - 1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combine(4, 2);
        for (List<Integer> utem : res) {
            System.out.println(utem.toString());
        }
    }
}
