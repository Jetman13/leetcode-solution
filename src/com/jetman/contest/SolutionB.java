package src.com.jetman.contest;

import java.util.*;

/**
 * @description: Solution
 * @author: Jetman
 * @create: 2019-04-04 20:59
 **/
public class SolutionB {


    boolean[][] flag = new boolean[1002][1002];
    int[][] row = {{0,1},{1,0},{0,-1},{-1,0}};
    int targei,targej;
    int targeColor;
    int orginColor;
    public int[][] colorBorder(int[][] grid, int i, int j, int color) {
        if (grid[i][j] == color) return grid;

        targei = i;
        targej = j;
        targeColor = color;
        orginColor = grid[i][j];

        return dfs(grid,i,j);
    }

    private int[][] dfs(int[][] grid,int i,int j) {
        if (isOver(i,j,grid.length,grid[0].length) || flag[i][j] || grid[i][j] != orginColor) {
            return grid;
        }

        flag[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int ri = i + row[k][0];
            int rj = j + row[k][1];
            dfs(grid,ri,rj);
            if (isOver(ri,rj,grid.length,grid[0].length) || (grid[ri][rj] != orginColor && !flag[ri][rj])) {
                grid[i][j] = targeColor;
            }
        }
        return grid;
    }

    private boolean isOver(int i,int j,int li,int lj) {
        if (i < 0 || j < 0 || i >= li || j >= lj) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {




    }

}
