package src.com.jetman.medium;

/**
 * @program:
 * @description: https://leetcode-cn.com/problems/zigzag-conversion/
 * @author: Jetman
 * @create: 2019-04-20 17:24
 **/
public class ZigzagConversion6 {

    public String convert(String s, int numRows) {
        if (s.length() <= 2 || numRows == 1 ) return s;

        int[][] flag = new int[numRows][s.length()/2 + 5];

        flag[0][0] = 1;
        int iindex = 1,jindex = 0;
        int num = numRows - 1;
        for (int i = 1; i < s.length(); i++) {
            flag[iindex][jindex] = i + 1;
            if ((i/num)%2 == 0) {
                iindex++;
            } else {
                iindex--;
                jindex++;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < flag.length; i++) {
            for (int j = 0; j < flag[i].length; j++) {
                if (flag[i][j] != 0) {
                    sb.append(s.charAt(flag[i][j] - 1));
                }
            }

        }
        Integer.valueOf("");
        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int num = 8;
        System.out.printf(""+new ZigzagConversion6().convert(s,num));
    }
}
