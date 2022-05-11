package com.company.two;

import com.company.LeetCode125;

import java.util.*;

public class LeetCode126 {
    List<List<String>> res = new ArrayList<>();
    List<List<String>> graph = new ArrayList<>();
    HashSet<String> marked = new HashSet<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord))
            return res;
        wordList.remove(beginWord);
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast(beginWord);
        HashSet<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);
        constructGraph(deque, wordSet);

        List<String> path = new ArrayList<>();
        path.add(beginWord);
        backtrack(beginWord, endWord, path, 0);
        return res;
    }

    public void backtrack(String beginword, String endword, List<String> path, int level) {

        if (beginword.equals(endword)) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; level < graph.size() && i < graph.get(level).size(); i++) {
            String s = graph.get(level).get(i);
            if (!isDifOne(s, path.get(path.size() - 1))) {
                continue;
            }
            path.add(s);
            backtrack(s, endword, path, level + 1);
            path.remove(path.size() - 1);
        }
    }

    public boolean isDifOne(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
        }
        return count == 1;
    }

    public void constructGraph(Deque<String> deque, HashSet<String> wordSet) {
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<String> path = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                String tmp = deque.removeFirst();
                path.add(tmp);

                char[] chars = tmp.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char ch = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == ch)
                            continue;
                        chars[j] = c;
                        String newString = buildString(chars);
                        if (wordSet.contains(newString) && !marked.contains(newString)) {
                            deque.addLast(newString);
                            marked.add(newString);
                        }
                    }
                    chars[j] = ch;
                }

            }
            graph.add(path);
        }
        graph.remove(0);
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
        LeetCode126 leetCode126 = new LeetCode126();
        leetCode126.findLadders("hit", "cog", wordList);
    }
}
