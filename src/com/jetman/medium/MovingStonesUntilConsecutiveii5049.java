package src.com.jetman.medium;

import java.util.Arrays;

/**
 * @program:
 * @description:
 * @author: Jetman
 * @create: 2019-05-06 22:02
 **/
public class MovingStonesUntilConsecutiveii5049 {

    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int min = getMin(stones);
        int max = getMax(stones);
        return new int[]{min,max};
    }

    private int getMax(int[] stones) {
        int max = 0;
        for (int i = 0; i < stones.length-1; i++) {
            max += stones[i+1] - stones[i] - 1;
        }
        int min = Math.min(stones[1]-stones[0],stones[stones.length-1]-stones[stones.length-2]);
        return max - min + 1;
    }

    private int getMin(int[] stones) {
        int length = stones.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < length-1; i++) {
            //最终序列是以stones[i]开头的最小值
            int index = Arrays.binarySearch(stones,stones[i]+length-1);
            int num;
            if (index >= 0) {
                num = index - i + 1;
            } else {
                index = Math.abs(index + 1);
                num = index - i;
            }
            //特殊场景
            if (num == length-1 && stones[i+num-1] - stones[i] == num-1) continue;

            ans = Math.min(ans,length - num);
        }
        return ans;
    }
}
