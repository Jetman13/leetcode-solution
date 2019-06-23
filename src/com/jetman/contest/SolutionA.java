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

    public void duplicateZeros(int[] arr) {
        int[] cp = new int[arr.length];
        List<Integer> link = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            link.add(arr[i]);
            if (arr[i] == 0) {
                link.add(arr[i]);
            }
            if (link.size() > arr.length) break;

        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = link.get(i);
        }

    }



    public static void main(String[] args) {
        int[] a = {0,2,6,2,7,5};
        new SolutionA().duplicateZeros(a);
        System.out.printf("");



    }

}
