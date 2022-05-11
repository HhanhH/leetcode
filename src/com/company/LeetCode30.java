package com.company;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode30 {
    private static List<Integer> slo(String str,String[] words){
        List<Integer> res = new ArrayList<>();
        if (words.length==0||str.length()==0) return  res;
        int len = words[0].length();
        int num = words.length;

        for (int i=0;i<=str.length()-len;i++){
            List<String> marked = new ArrayList<>();
            for (String word:words){
                marked.add(word);
            }
            int j = i+len*num;
            if (j>str.length()) break;
            String sub = str.substring(i,j);
            for (int k=0;k<=j-i-len;k+=len){
                String s = sub.substring(k,k+len);
                if (marked.contains(s)){
                    marked.remove(s);
                }else {
                    break;
                }
            }
            if (marked.size()==0){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String  str = "a";
        String[] words= {"a"};
        System.out.println(slo(str,words).toString());
    }
}
