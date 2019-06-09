package src.com.jetman.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: za-graphene-anan
 * @description: https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @author: za-zhangmin
 * @create: 2019-05-25 16:36
 **/
public class LetterCombinationsOfAPhoneNumber17 {

    List<String>[] letter = new List[]{null, null, Arrays.asList("a", "b", "c"),
            Arrays.asList("d", "e", "f"),
            Arrays.asList("g", "h", "i"),
            Arrays.asList("j", "k", "l"),
            Arrays.asList("m", "n", "o"),
            Arrays.asList("p", "q", "r", "s"),
            Arrays.asList("t", "u", "v"),
            Arrays.asList("w", "x", "y", "z")};
    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) return new ArrayList<>();
        if (digits.length() == 1) return letter[digits.charAt(0) - '0'];

        List<String> tmp = letterCombinations(digits.substring(1));
        List<String> pre = letter[digits.charAt(0) - '0'];
        return merge(tmp,pre);
    }

    private List<String> merge(List<String> tmp, List<String> pre) {
        List<String> ans = new ArrayList<>();
        for (String s : pre) {
            for (String s1 : tmp) {
            ans.add(s+s1);
            }
        }
        return ans;
    }
}
