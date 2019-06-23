package src.com.jetman.contest;



import java.util.*;

/**
 * @description: Solution
 * @author: Jetman
 * @create: 2019-04-04 20:59
 **/
public class SolutionB {
    static int[] values;
    static int[] labels;
    public int largestValsFromLabels(int[] v, int[] l, int num_wanted, int use_limit) {

        values = v;
        labels = l;
        Queue<PriorityQueue<Integer>> queues = new PriorityQueue<PriorityQueue<Integer>>((a,b) -> values[b.peek()]-values[a.peek()]);
        Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        int len = values.length;
        for (int i = 0; i < len; i++) {
            PriorityQueue<Integer> tmp = map.getOrDefault(labels[i], new PriorityQueue<>((a,b) -> (values[b]-values[a])));
            tmp.add(i);
            map.put(labels[i],tmp);
        }


        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {

            queues.add(entry.getValue());
        }
        int ans = 0;
        Map<Integer,Integer> numMap = new HashMap<>();
        while (num_wanted > 0 && !queues.isEmpty()) {
            PriorityQueue<Integer> queue = queues.poll();
            int index = queue.poll();
            Integer num = numMap.getOrDefault(labels[index], 0);
            if (num >= use_limit) continue;

            ans += values[index];
            num_wanted--;
            numMap.put(labels[index],num+1);

            if (!queue.isEmpty()) queues.add(queue);

        }

        return ans;


    }


    public static void main(String[] args) {
        long sta = System.currentTimeMillis();
        int[] a = {5,4,3,2,1};
        int[] b = {1,3,3,3,2};
        System.out.println(""+new SolutionB().largestValsFromLabels(a,b,3,2));
        System.out.println("all = "+(System.currentTimeMillis()-sta));

    }

}
