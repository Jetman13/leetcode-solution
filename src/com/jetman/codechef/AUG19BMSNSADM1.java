package src.com.jetman.codechef;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: https://www.codechef.com/AUG19B/problems/MSNSADM1
 * @author: Jetman
 * @create: 2019-08-03 22:14
 **/
public class AUG19BMSNSADM1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while ((t--) > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                a[i]*=20;
            }
            for (int i = 0; i < n; i++) {
                int k = sc.nextInt();
                a[i]-=k*10;
            }
            Arrays.sort(a);
            System.out.println(a[a.length-1] > 0 ? a[a.length-1] : 0);
        }
    }
}
