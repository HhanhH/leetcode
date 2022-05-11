package com.company;


/**
 * 外观数组
 * 1
 * 11
 * 21
 * 1211
 * 111221
 * 312211
 * 13112221
 * 1113213211
 * 31131211131221
 * 13211311123113112211
 */
public class LeetCode38 {
    private static String slo(int n) {

        String[] dp = new String[n + 1];
        dp[1] = "1";

        for (int i = 2; i <= n; i++) {
            dp[i] = say(dp[i - 1]);
        }
        String res = dp[n];
        StringBuilder builder = new StringBuilder(res);
        return builder.reverse().toString();
    }

    private static String say(String s) {
        char[] c = s.toCharArray();
        int count = 0;
        char p;
        int i = 0;
        StringBuilder builder = new StringBuilder();

        while (i < c.length) {
            p = c[i];
            count++;
            while ( i < c.length - 1&&p == c[i + 1]) {
                count++;
                i++;
            }
            builder.append(p - '0').append(count);
            i++;
            count = 0;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(slo(i));
        }
    }
}
