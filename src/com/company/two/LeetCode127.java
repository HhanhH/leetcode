package com.company.two;

import java.util.*;

public class LeetCode127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        wordList.remove(beginWord);
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast(beginWord);
        HashSet<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);
        HashSet<String> marked = new HashSet<>();

        int count = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String tmp = deque.removeFirst();
                char[] chars = tmp.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char ch = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == ch)
                            continue;
                        chars[j] = c;
                        String newString = buildString(chars);
                        if (newString.equals(endWord)){
                            marked.add(newString);
                            return count+1;
                        }
                        if (wordSet.contains(newString) && !marked.contains(newString)) {
                            deque.addLast(newString);
                            marked.add(newString);
                        }
                    }
                    chars[j] = ch;
                }

            }
            count++;
        }
        return 0;
    }


    public String buildString(char[] chars) {
        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            builder.append(c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        LeetCode127 leetCode126 = new LeetCode127();
        System.out.println(leetCode126.ladderLength("hit", "cog", wordList));
    }
}
