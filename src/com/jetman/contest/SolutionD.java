package src.com.jetman.contest;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: za-graphene-anan
 * @description: test
 * @author: za-zhangmin
 * @create: 2019-04-04 20:59
 **/
public class SolutionD {

    public List<String> braceExpansionII(String expression) {
        Set<String> ans = go(expression);

        List<String> list = ans.stream().collect(Collectors.toList());
        list.sort((a,b)-> a.compareTo(b));
        return list;
    }

    private Set<String> go(String expression) {
        expression = getWhole(expression);
        String[] splits = splitByComma(expression);


        Set<String> ans = new HashSet<>();
        for (int i = 0; i < splits.length; i++) {
            Set<String> tmp = go(splits[i]);
            ans.addAll(tmp);
        }

        return ans;
    }

    private String[] splitByComma(String ex) {
        return null;
    }

    private String getWhole(String ex) {
        while (ex.charAt(0) == '{'){
            int left = 1;
            int end = -1;
            for (int i = 1; i < ex.length(); i++) {
                if (ex.charAt(i) == '}') {
                    left--;
                } else if (ex.charAt(i) == '{') {
                    left++;
                }
                if (left == 0) {
                    end = i;
                    break;
                }
            }
            if (end != ex.length()-1) return ex;

            ex = ex.substring(1,ex.length()-1);
        }
        return ex;
    }

    public static void main(String[] args) {

        int[] p = {200,600,100,180,300,450};
        int[] v = {6,10,3,4,5,8};

//        System.out.printf(""+new SolutionD().findBest(p,v,6,300));




    }

}
