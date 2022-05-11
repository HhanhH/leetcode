package com.company;

public class LeetCode125 {
    public boolean isPalindrome(String s) {
        return check(s, 0, s.length() - 1);
    }

    public boolean check(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        while (start <= end && !isValid(s.charAt(start)))
            start++;
        if (start > end) return true;

        while (end >= start && !isValid(s.charAt(end))) {
            end--;
        }
        if (end < start) return true;
        if (start <= end) {
            if (s.substring(start, start + 1).equalsIgnoreCase(s.substring(end, end + 1))) {
                return check(s, start + 1, end - 1);
            }
        }
        return false;
    }

    public boolean isValid(char s) {
        if ((s >= 'A' && s <= 'Z') || (s >= 'a' && s <= 'z') || (s >= '0' && s <= '9')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode125 leetCode125 = new LeetCode125();
        System.out.println(leetCode125.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
