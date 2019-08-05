package src.com.jetman.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @program:
 * @description: https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters/
 * @author: Jetman
 * @create: 2019-06-15 23:12
 **/
public class SmallestSubsequenceOfDistinctCharacters1081 {

    public String smallestSubsequence(String text) {

        if (text.length() == 1) return text;

        boolean[] flag = new boolean[300];
        int[] num = new int[300];
        for (int i = 0; i < text.length(); i++) {
            num[text.charAt(i)]++;
        }
        Stack<Character> stack = new Stack<>();
        stack.add(text.charAt(0));
        flag[text.charAt(0)] = true;
        num[text.charAt(0)]--;

        int len = text.length();

        for (int i = 1; i < len; i++) {
            Character ch = text.charAt(i);
            num[ch]--;
            if (flag[ch]) continue;

            while (!stack.isEmpty() && stack.peek() > ch && num[stack.peek()] > 0) {
                flag[stack.peek()] = false;
                stack.pop();
            }
            stack.add(ch);
            flag[ch] = true;
        }

        return stack.stream().map(p->p.toString()).reduce((a,b)->a+b).get();

    }

    private boolean check(Character top, int i, String text) {
        for (int j = i; j < text.length(); j++) {
            if (text.charAt(j) == top) {
                return true;
            }
        }
        return false;
    }
}
