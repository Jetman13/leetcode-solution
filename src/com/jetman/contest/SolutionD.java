package src.com.jetman.contest;

import java.util.*;

/**
 * @program: za-graphene-anan
 * @description: test
 * @author: za-zhangmin
 * @create: 2019-04-04 20:59
 **/
public class SolutionD {

    public class JetNode {
        public int num;
        public int val;
        public JetNode(int x,int y) { val = x;
        num = y;}

        public void ins() {
            num++;
        }
        public void des() {
            num--;
        }
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        if (barcodes.length <3) return barcodes;

        int len = barcodes.length;

        Queue<JetNode> queue = new PriorityQueue<>(10002,(a,b) -> b.num - a.num);


        Map<Integer,JetNode> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            JetNode node = map.getOrDefault(barcodes[i],new JetNode(barcodes[i],0));
            node.ins();
            map.put(barcodes[i],node);
        }

        for (Map.Entry<Integer, JetNode> entry : map.entrySet()) {
            queue.add(entry.getValue());
        }

        int[] ans = new int[len];
        int index = 0;
        ans[index++] = pollAndSet(queue);

        while (!queue.isEmpty()) {
            JetNode jetmp = queue.peek();
            if (ans[index-1] == jetmp.val) {
                queue.poll();
                ans[index++] = pollAndSet(queue);
                queue.add(jetmp);
            } else {
                ans[index++] = pollAndSet(queue);
            }
        }

        return ans;

    }

    private int pollAndSet(Queue<JetNode> queue) {
        JetNode j2 = queue.poll();
        int val = j2.val;
        j2.des();
        if (j2.num > 0) {
            queue.add(j2);
        }
        return val;
    }

    public int findBest(int[] prices,int[] vals,int len,int total) {
        int[][] dp = new int[102][1002];
        if (total <= 0) return 0;

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= total; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= prices[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j-prices[i-1]] + vals[i-1],dp[i-1][j]);
                }
            }

        }

        return dp[len][total];
    }

    int findMax(int a,int b) {
        return a>b?a:b;
    }


    public static void main(String[] args) {

        int[] p = {200,600,100,180,300,450};
        int[] v = {6,10,3,4,5,8};

        System.out.printf(""+new SolutionD().findBest(p,v,6,300));




    }

}
