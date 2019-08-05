package src.com.jetman.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/contest/weekly-contest-140/problems/occurrences-after-bigram/
 * @author: Jetman
 * @create: 2019-06-09 13:44
 **/
public class OccurrencesAfterBigram5083 {

    public String[] findOcurrences(String text, String first, String second) {
        String[] strs = text.split(" ");
        List<String> ans = new ArrayList<>();

        for (int i = 1; i < strs.length-1; i++) {
            if (strs[i-1].equals(first) && strs[i].equals(second)) {
                ans.add(strs[i+1]);
            }
        }

        return ans.toArray(new String[ans.size()]);
    }
}
