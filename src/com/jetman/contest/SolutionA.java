package src.com.jetman.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: Solution
 * @author: Jetman
 * @create: 2019-04-04 20:59
 **/
public class SolutionA {


    public boolean divisorGame(int N) {
        boolean[] flag = new boolean[1003];

        flag[1] = false;
        flag[2] = true;
        flag[3] = false;
        flag[4] = true;

        for (int i = 5; i <= N; i++) {
            boolean k = false;
            for (int j = 1; j <= i/2; j++) {
                if (i%j == 0 && !flag[i-j]) {
                    k = true;
                }
            }
            flag[i] = k;
        }

        return flag[N];
    }


    public static void main(String[] args) {
        int[] a = {0,1,1,1,1,1};



    }

}
