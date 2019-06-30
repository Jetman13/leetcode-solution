package src.com.jetman.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: Solution
 * @author: Jetman
 * @create: 2019-04-04 20:59
 **/
public class SolutionA {

    public int[] distributeCandies(int candies, int num_people) {
        int[] p = new int[num_people];
        int num = 1;
        int index = 0;
        while (candies > 0) {
            if (candies >= num) {
                p[index] += num;
                candies-=num;
            } else {
                p[index]+= candies;
                candies = 0;
            }
            num++;
            index = (index+1)%num_people;
        }
        return p;
    }


    public static void main(String[] args) {
        int[] a = {0,2,6,2,7,5};
//        new SolutionA().duplicateZeros(a);
        System.out.printf("");



    }

}
