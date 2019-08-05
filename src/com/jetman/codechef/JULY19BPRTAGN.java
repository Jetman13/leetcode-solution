package src.com.jetman.codechef;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @description: https://www.codechef.com/JULY19B/problems/PRTAGN
 * @author: Jetman
 * @create: 2019-07-06 09:59
 **/
public class JULY19BPRTAGN {

//    static int[] table = new int[131076];
//    static boolean[] flag;
//    static int evenNum,oddNum;
//    static List<Integer> nums = new ArrayList<>();

    static int[] bit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while ((t--) > 0) {
//            flag = new boolean[131076];
//            evenNum = oddNum = 0;
//            nums.clear();
            bit = new int[32];
            int x = sc.nextInt();
            for (int i = 0; i < x; i++) {
                int q = sc.nextInt();
                work(q);
            }

        }
    }

    private static void work(int q) {
        int index = 0;
        while (q != 0) {
            if ((q&1) == 1) {
                bit[index] = 1;
            }
            q/=2;
            index++;
        }

        int bitNum =(int) Arrays.stream(bit).filter(p -> p == 1).count();
        int sum = (1<<bitNum) - 1;
        System.out.println(sum/2 + " " + (sum/2+1));
    }

//    private static void work(int q) {
//        List<Integer> tmpList = new ArrayList<>();
//        if (setFlag(q) >= 0) {
//            nums.add(q);
//        }
//        nums.stream().forEach(p -> {
//            if (p != q) {
//                int tmp = p^q;
//                if (setFlag(tmp) >= 0) {
//                    tmpList.add(tmp);
//                }
//            }
//        });
//        nums.addAll(tmpList);
//        System.out.println(evenNum + " " + oddNum);
//    }
//
//    private static int setFlag(int tmp) {
//        if (!flag[tmp]) {
//            if (table[tmp] == 0) {
//                table[tmp] = getBitNum(tmp);
//            }
//            if (table[tmp] == 1) {
//                oddNum++;
//            } else {
//                evenNum++;
//            }
//            flag[tmp] = true;
//            return tmp;
//        }
//        return -1;
//    }
//
//    private static int getBitNum(int n) {
//        int c =0 ;
//        for (c =0; n > 0; ++c)
//        {
//            n &= (n -1) ; // 清除最低位的1
//        }
//        return (c&1) == 0 ? 2 : 1;
//    }1
}
