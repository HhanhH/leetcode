package com.company;

import javafx.util.Builder;

import java.util.ArrayList;
import java.util.List;

public class LeetCode68 {
    public static List<String> fullJustify(String[] words, int maxWidth) {

        List<String> line = new ArrayList<>();
        List<String> res = new ArrayList<>();
        int count = 0;
        int index = 0;
        while (index < words.length) {
            if (count + words[index].length() + line.size() > maxWidth) {
                int space = maxWidth - count;
                int sp = line.size() - 1;
                StringBuilder bu = new StringBuilder();
                if (line.size() == 1) {
                    bu.append(line.get(0));
                    while (space > 0) {
                        bu.append(" ");
                        space--;
                    }
                } else {
                    int every = space / sp;
                    int mod = space % sp;
                    int c = 0;
                    for (String item : line) {
                        bu.append(item);
                        int i = every + (++c <= mod ? 1 : 0);
                        while (i > 0 && sp > 0) {
                            bu.append(" ");
                            i--;
                        }
                        sp--;

                    }
                }
                res.add(bu.toString());
                count = 0;
                line = new ArrayList<>();

            } else {
                count += words[index].length();
                line.add(words[index]);
                index++;
            }
        }

        if (line.size() > 0) {
            StringBuilder bu = new StringBuilder();
            for (String item : line) {
                bu.append(item);
                if (bu.length() < maxWidth)
                    bu.append(" ");
            }
            int spx = maxWidth - bu.length();
            while (spx > 0) {
                bu.append(" ");
                spx--;
            }
            res.add(bu.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
//                {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> res = fullJustify(words, 16);
        for (String item : res) {
            System.out.println(item);
        }
    }
}
