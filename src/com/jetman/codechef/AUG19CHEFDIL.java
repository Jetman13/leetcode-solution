package src.com.jetman.codechef;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Jetman
 * @create: 2019-08-04 14:34
 **/
public class AUG19CHEFDIL {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while ((t--) > 0) {
            String str = sc.next();
            boolean[] flag = new boolean[str.length()];
            char[] chs = str.toCharArray();
            System.out.println(win(chs,flag)?"WIN":"LOSE");
        }
    }

    private static boolean win(char[] chs,boolean[] flag) {
        int len = chs.length;
        int pre = -1;
        for (int i = 0; i < len; i++) {
            if (chs[i] == '1') {
                if (i+1<len) chs[i+1] = chs[i+1] == '1'?'0':'1';
                pre = i;
            }
        }
        return pre == len-1;
    }
}
