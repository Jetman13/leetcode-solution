package src.com.jetman.contest;



import java.util.*;

/**
 * @description: Solution
 * @author: Jetman
 * @create: 2019-04-04 20:59
 **/
public class SolutionB {


    public List<Integer> pathInZigZagTree(int label) {

        int[] pow = new int[32];
        pow[1] = 1;
        for (int i = 2; i < 30; i++) {
            pow[i] = (pow[i-1]+1)*2 -1;
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(label);
        while (label > 1) {
            label/=2;
            int p = getStart(pow,label);
            int s = pow[p-1] + 1;
            int e = pow[p];
            label = s+e-label;
            ans.add(label);
        }

        Collections.reverse(ans);
        return ans;

    }

    private int getStart(int[] pow, int label) {
        for (int i = 1; i < 31; i++) {
            if (pow[i] >= label && pow[i-1] < label) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        long sta = System.currentTimeMillis();
        int[] a = {5,4,3,2,1};
        int[] b = {1,3,3,3,2};
//        System.out.println(""+new SolutionB().largestValsFromLabels(a,b,3,2));
        System.out.println("all = "+(System.currentTimeMillis()-sta));

    }

}
