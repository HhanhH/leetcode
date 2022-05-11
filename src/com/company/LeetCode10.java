package com.company;

public class LeetCode10 {
    private static boolean slo(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l2 == 0) {
            return l1 == 0;
        }


        boolean firstMatch = (l1 > 0 && l2 > 0) && (s1.charAt(0) == s2.charAt(0) || s2.charAt(0) == '.');

        if (l2 > 1 && s2.charAt(1) == '*') {
            return (firstMatch && slo(s1.substring(1), s2)) || slo(s1, s2.substring(2));
        } else {
            return firstMatch && slo(s1.substring(1), s2.substring(1));

        }
    }

    public static void main(String[] args) {
//        System.out.println(slo("aa", "a"));
//        System.out.println(slo("aa", "a*"));
//        System.out.println(slo("ab", ".*"));

            String s = "http://ddsfsdf/dfsd?sdfdsf";
            System.out.println(s.split("\\?")[0]);
    }
}
