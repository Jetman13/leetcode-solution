package src.com.jetman.codechef;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @description: https://www.codechef.com/JULY19B/problems/MMAX
 * @author: Jetman
 * @create: 2019-07-05 23:02
 **/
public class JULY19BMMAX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while ((t--) > 0) {
            int nint = sc.nextInt();
            BigDecimal n = new BigDecimal(nint);
            String kStr = sc.next();
            BigDecimal k = new BigDecimal(kStr);

            BigDecimal remainder = k.remainder(n);

            int remain = remainder.intValue();

            int ans = Math.min(nint-remain,remain)*2;
            if (nint == 2*remain) ans--;
            System.out.println(ans);

        }
    }
}
