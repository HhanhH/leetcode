package com.company;

/**
 * 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class LeetCode32 {
    private static int slo(String str) {
        if (str.length() <= 1) {
            return 0;
        }
        char[] s = str.toCharArray();
        if (str.length() == 2) {
            return (s[0] == '(' && s[1] == ')') ? 2 : 0;
        }
        int[] dp = new int[str.length()];
        int max = 0;
        dp[0] = 0;
        dp[1] = (s[0] == '(' && s[1] == ')') ? 2 : 0;
        max = Math.max(max, dp[1]);
        for (int i = 2; i < str.length(); i++) {
            // i -> (
            if (s[i] == '(')
                dp[i] = 0;
            else {
                //i --> )
                if (s[i - 1] == '(') {//*****()
                    dp[i] = dp[i - 2] + 2;
                } else {  //*****))
                    //(*****))  (*****)已经是dp[i-1]最长的段了  所以如果前面是）则一定不匹配，不然dp[i-1]可以再长
                    if (i - dp[i - 1] == 0)
                        dp[i] = 0;
                    else if (s[i - dp[i - 1] - 1] == ')')
                        dp[i] = 0;
                    else
                        //*****((*****))
                        if (i - dp[i - 1] - 1 == 0) {
                            dp[i] = dp[i - 1] + 2;
                        } else {
                            dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                        }
                }
            }
            max = Math.max(max, dp[i]);

        }
        return max;
    }

    public static void main(String[] args) {
        String str = "())";
        System.out.println(slo(str));
    }
}
