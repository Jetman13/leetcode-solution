package src.com.jetman.contest;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @description: Solution
 * @author: Jetman
 * @create: 2019-04-04 20:59
 **/
public class SolutionB {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {

        int tmp = 0;
        int len = customers.length;
        for (int i = 0; i < len; i++) {
            tmp += grumpy[i] == 1 ? 0 : customers[i];
        }

        int l = 0;
        int r = 0;
        int xtmp = 0;
        for (; r < X; r++) {
            xtmp += grumpy[r] == 1 ? customers[r] : 0;
        }

        int ans = tmp + xtmp;

        for (l++; r < len; r++,l++) {
            if (grumpy[l-1] == 1) xtmp -= customers[l-1];
            if (grumpy[r] == 1) xtmp += customers[r];
            ans = Math.max(ans,tmp+xtmp);
        }
        return ans;
    }


    public static void main(String[] args) {
        long sta = System.currentTimeMillis();
        int[] a = {1,0,1,2,1,1,7,5};
        int[] b = {0,1,0,1,0,1,0,1};
        System.out.println(""+new SolutionB().maxSatisfied(a,b,3));
        System.out.println("all = "+(System.currentTimeMillis()-sta));

    }

}
