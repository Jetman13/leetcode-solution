package src.com.jetman.hard;

/**
 * @description: https://leetcode-cn.com/contest/weekly-contest-141/problems/shortest-common-supersequence/
 * @author: Jetman
 * @create: 2019-06-16 14:51
 **/
public class ShortestCommonSupersequence1092 {

    public String shortestCommonSupersequence(String str1, String str2) {
        String sub = LCS_caculate(str1,str2);

        StringBuilder sb = new StringBuilder();
        int indexi = 0;
        int indexj = 0;
        for (int i = 0; i < sub.length(); i++) {

            while (str1.charAt(indexi) != sub.charAt(i)) {
                sb.append(str1.charAt(indexi++));
            }
            while (str2.charAt(indexj) != sub.charAt(i)) {
                sb.append(str2.charAt(indexj++));
            }
            indexi++;
            indexj++;
            sb.append(sub.charAt(i));
        }

        while (indexi < str1.length()) {
            sb.append(str1.charAt(indexi++));
        }
        while (indexj < str2.length()) {
            sb.append(str2.charAt(indexj++));
        }

        return sb.toString();

    }


    public String LCS_caculate(String s1,String s2){
        int size1=s1.length();
        int size2=s2.length();
        int chess[][]=new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=size1;i++){//根据上面提到的公式计算矩阵
            for(int j=1;j<=size2;j++){
                if (s1.charAt(i-1)==s2.charAt(j-1)) {
                    chess[i][j]=chess[i-1][j-1]+1;
                }else {
                    chess[i][j]=Math.max(chess[i][j-1],chess[i-1][j]);
                }
            }
        }
        int i=size1;
        int j=size2;
        StringBuffer sb=new StringBuffer();
        while((i!=0)&&(j!=0)){//利用上面得到的矩阵计算子序列，从最右下角往左上走
            if (s1.charAt(i-1)==s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));//相同时即为相同的子串
                i--;
                j--;
            }else {
                if (chess[i][j-1]>chess[i-1][j]) {
                    j--;
                }else {
                    i--;
                }
            }
        }
        return sb.reverse().toString();//记得反转
    }

    public static void main(String[] args) {
        String a = "abac";
        String b = "cab";
        System.out.printf(""+new ShortestCommonSupersequence1092().shortestCommonSupersequence(a,b));
    }

}
