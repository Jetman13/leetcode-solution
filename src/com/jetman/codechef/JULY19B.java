package src.com.jetman.codechef;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: https://www.codechef.com/JULY19B/problems/CHFM
 * @author: Jetman
 * @create: 2019-07-05 19:56
 **/
public class JULY19B {

    static long[] a = new long[1003];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while ((t--) > 0) {
            int n = sc.nextInt();
            long sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                sum+=a[i];
            }
            if (sum % n != 0) {
                System.out.println("Impossible");
                continue;
            }
            long p = sum/n;
            int index = -1;
            for (int i = 0; i < n; i++) {
                if (a[i] == p) {
                    index = i + 1;
                    break;
                }
            }
            if (index < 0) {
                System.out.println("Impossible");
            } else {
                System.out.println(index);
            }
        }
    }
}
