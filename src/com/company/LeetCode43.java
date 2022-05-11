package com.company;

public class LeetCode43 {
    public String multiply(String num1, String num2) {
        if (num1.equalsIgnoreCase("0") || num2.equalsIgnoreCase("0")) {
            return "0";
        }
        int[] cu = new int[num1.length() + num2.length()];
        int x;
        int y;
        for (int i = 0; i < num1.length(); i++) {
            x = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                y = num2.charAt(j) - '0';
                cu[i + j + 1] += x * y;
            }
        }

        for (int i = cu.length - 1; i > 0; i--) {
            cu[i - 1] += cu[i] / 10;
            cu[i] = cu[i] % 10;
        }

        int index = cu[0] == 0 ? 1 : 0;
        StringBuilder bu = new StringBuilder();
        for (; index < cu.length; index++) {
            bu.append(cu[index]);
        }

        return bu.toString();
    }

    public static void main(String[] args) {
        System.out.println((new LeetCode43()).multiply("19", "100"));
    }
}
