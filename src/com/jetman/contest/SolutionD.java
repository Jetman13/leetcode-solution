package src.com.jetman.contest;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: za-graphene-anan
 * @description: test
 * @author: za-zhangmin
 * @create: 2019-04-04 20:59
 **/
public class SolutionD {

    Set<String> blockedSet = new HashSet<>();
    Set<String> flag = new HashSet<>();
    int num = 0;
    int maxNum = 100*100*2;
    boolean ans;
    int[][] row = {{0,1},{1,0},{0,-1},{-1,0}};
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {

        for (int i = 0; i < blocked.length; i++) {
            blockedSet.add(blocked[i][0] + "" + blocked[i][1]);
        }

        dfs(source[0],source[1],target);
        if (ans) return ans;

        if (num < maxNum) {
            return false;
        }
        num = 0;
        flag.clear();
        dfs(target[0],target[1], source);

        return ans || num >= maxNum;

    }

    private void dfs(int i,int j, int[] target) {

        if (ans || isOver(i,j) || isFlag(i,j) || num >= maxNum) {
            return;
        }
        if (i == target[0] && j == target[1]) {
            ans = true;
            return ;
        }
        num++;
        setFlag(i,j);
        for (int k = 0; k < 4; k++) {
            int ri = i + row[k][0];
            int rj = j + row[k][1];
            dfs(ri,rj,target);
        }
        return;
    }

    private void setFlag(int i, int j) {
        String key = i + "" + j;
        flag.add(key);
    }

    private boolean isFlag(int i, int j) {
        String key = i + "" + j;
        return flag.contains(key);
    }

    private boolean isOver(int i,int j) {
        String key = i + "" + j;
        if (blockedSet.contains(key)) {
            return true;
        }
        if (i < 0 || j < 0 || i > 1000000 || j > 1000000) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {


        long start = System.currentTimeMillis();
        int tem = 0;
        int[][] am = new int[10001][10001];
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 10000; j++) {
                tem = (tem + i*j)%42343;
                am[i%10000][j%10000] = i+j;
            }

        }

        System.out.println(""+(System.currentTimeMillis() - start));



    }

}
