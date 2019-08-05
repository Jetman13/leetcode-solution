package src.com.jetman.codechef;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: https://www.codechef.com/AUG19B/problems/ZOMCAV
 * @author: Jetman
 * @create: 2019-08-04 15:15
 **/
public class AUG19ZOMCAV {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while ((t--) > 0) {
            int n = sc.nextInt();
            int[] c = new int[n+3];
            int[] h = new int[n+3];
            int[] f = new int[n+3];
            for (int i = 1; i <= n; i++) {
                c[i] = sc.nextInt();
                int l = i - c[i] <= 0 ? 1:i-c[i];
                int r = i + c[i] > n ? n:i+c[i];
                f[l]++;
                f[r+1]--;
            }
            for (int i = 0; i < n; i++) {
                h[i] = sc.nextInt();
            }
            int num = 0;
            for (int i = 1; i <= n; i++) {
                num+=f[i];
                c[i-1] = num;
            }
            Arrays.sort(c,0,n);
            Arrays.sort(h,0,n);

            boolean flag = true;

            for (int i = 0; i < n; i++) {
                if (c[i]!=h[i]) {
                    flag = false;
                    break;
                }
            }

            System.out.println(flag?"YES":"NO");
        }
    }
}
