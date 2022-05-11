package com.company;

public class LeetCode67 {
    public String addBinary(String a, String b) {
        if (a.equalsIgnoreCase("0")) {
            return b;
        }
        if (b.equalsIgnoreCase("0"))
            return a;
        char[] n1 = a.toCharArray();
        char[] n2 = b.toCharArray();

        int len1 = n1.length - 1;
        int len2 = n2.length - 1;

        int c = 0;
        StringBuilder builder = new StringBuilder();
        while (len1 >= 0 && len2 >= 0) {

            int x = n1[len1] - '0';
            int y = n2[len2] - '0';
            builder.append((x + y + c) % 2);
            c = (x + y + c) / 2;
            len1--;
            len2--;
        }

        while (len1 >= 0) {
            int n = n1[len1] - '0';
            builder.append((n + c) % 2);
            c = (n + c) / 2;
            len1--;
        }
        while (len2 >= 0) {
            int n = n2[len2] - '0';
            builder.append((n + c) % 2);
            c = (n + c) / 2;
            len2--;
        }
        if (c > 0) {
            builder.append(c);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode67().addBinary("11", "1"));
    }
}
