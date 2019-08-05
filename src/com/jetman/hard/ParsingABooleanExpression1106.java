package src.com.jetman.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/contest/weekly-contest-143/problems/parsing-a-boolean-expression/
 * @author: Jetman
 * @create: 2019-06-30 17:04
 **/
public class ParsingABooleanExpression1106 {

    String exp;
    public boolean parseBoolExpr(String expression) {
        exp = expression;

        return work(0,exp.length());

    }

    private boolean work(int start, int end) {
        if (end - start == 1) {
            return exp.charAt(start) == 't';
        }
        char ch = exp.charAt(start);
        if (ch == '!') {
            return !work(start+2,end-1);
        } else {
            List<Boolean> bools = new ArrayList<>();
            int num = 0;
            int p = start + 2;
            for (int i = start+2; i < end; i++) {
                if (exp.charAt(i) == '(') {
                    num++;
                } else if (exp.charAt(i) == ')') {
                    num--;
                } else if (exp.charAt(i) == ',' && num == 0) {
                    bools.add(work(p,i));
                    p = i+1;
                }
            }
            bools.add(work(p,end-1));
            if (ch == '|') {
                return bools.stream().reduce((a,b) -> a|b).get();
            } else {
                return bools.stream().reduce((a,b) -> a&b).get();
            }
        }
    }

    public static void main(String[] args) {
        String p = "!(&(!(t),&(f),|(f)))";

        System.out.println("" + new ParsingABooleanExpression1106().parseBoolExpr(p));
    }
}
