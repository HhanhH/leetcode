package com.company;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode71 {
    public static String simplifyPath(String path) {
        String[] s = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String s1 : s) {
            if (s1.equalsIgnoreCase("") || s1.equalsIgnoreCase("."))
                continue;
            if (s1.equalsIgnoreCase("..")) {
                if (!stack.isEmpty())
                    stack.removeLast();
                else continue;
            } else {
                stack.addLast(s1);
            }
        }
        if (stack.isEmpty()) return "/";
        StringBuilder builder = new StringBuilder("/");
        while (!stack.isEmpty()) {
            builder.append(stack.removeFirst()).append("/");
        }
        return builder.substring(0, builder.length() - 1);

    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/../"));
    }
}
