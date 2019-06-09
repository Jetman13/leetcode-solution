package src.com.jetman.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: Solution
 * @author: Jetman
 * @create: 2019-04-04 20:59
 **/
public class SolutionA {

    public String gcdOfStrings(String str1, String str2) {

        int len1 = str1.length();
        int len2 = str2.length();
        String str = str1 + str2;

        for (int i = 1000; i > 0 ; i--) {
            if (len1%i == 0 && len2%i==0) {
                if (work(str,i)) {
                    return print(str1,i);
                }
            }
        }
        return "";
    }

    private String print(String str, int i) {
        return str.substring(0,i);
    }

    private boolean work(String str, int i) {
        int len = str.length();
        int fo = len/i;
        int index = 0;
        for (int j = 0; j < fo; j++) {
            for (int k = 0; k < i; k++) {
                if (str.charAt(index++) != str.charAt(k)) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] a = {0,2,6,2,7,5};
//        System.out.printf(""+new SolutionA().lastStoneWeight(a));



    }

}
