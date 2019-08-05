package src.com.jetman.contest;

import src.com.jetman.base.TreeNode;

import java.util.*;

/**
 * @description: Solution
 * @author: Jetman
 * @create: 2019-04-04 20:59
 **/
public class SolutionC {

    int snapNum;
    List<Integer>[] snapLog;
    Map<Long,Integer> map;
    public SolutionC(int length) {
        snapNum = 0;
        snapLog = new ArrayList[length+2];
        map = new HashMap<>(length+3);

    }

    public void set(int index, int val) {
        Long key = (long)index*100000 + snapNum;
        List<Integer> logList = snapLog[index];
        if (logList != null) {
            Integer pre = logList.get(snapLog[index].size() - 1);
            if (pre != snapNum) {
                logList.add(snapNum);
            }
        } else {
            snapLog[index] = new ArrayList<Integer>();
            if (snapNum != 0)snapLog[index].add(0);
            snapLog[index].add(snapNum);
        }
        map.put(key,val);
    }

    public int snap() {
        snapNum++;
        return snapNum-1;
    }

    public int get(int index, int snap_id) {
        List<Integer> logList = snapLog[index];
        if (logList == null) return 0;

        int i = bi(logList, snap_id);
        int snapk = i< 0 ? (-i-1) : i;
        Long key = (long)index*100000 + logList.get(snapk);
        return map.getOrDefault(key,0);
    }

    private int bi(List<Integer> logList, int snap_id) {
        int l = 0;
        int r = logList.size()-1;
        while (l < r) {
            int mid = (l+r)/2;
            int val = logList.get(mid).intValue();
            if (val == snap_id) return mid;
            else if (val < snap_id) {
                if (mid+1<logList.size() && logList.get(mid+1) > snap_id) return mid;
                l = mid + 1;
            }else {
                if (mid-1 >= 0 && logList.get(mid-1) < snap_id) return mid-1;
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {

        SolutionC obj = new SolutionC(4);
        obj.set(1,5);
        obj.snap();
        obj.set(0,16);
        obj.snap();
        obj.set(2,15);
        obj.snap();
        obj.set(2,5);
        System.out.println(obj.get(1,0));
        System.out.println(obj.get(0,2));

    }

}
