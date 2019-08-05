package src.com.jetman.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description: https://leetcode-cn.com/problems/letter-tile-possibilities/
 * @author: Jetman
 * @create: 2019-06-22 15:09
 **/
public class LetterTilePossibilities1079 {

    public int numTilePossibilities(String tiles) {

        int len = tiles.length();
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<len;i++) {
            int num = map.getOrDefault(tiles.charAt(i),0);
            num++;
            map.put(tiles.charAt(i),num);
        }

        return count(map)-1;

    }

    private int count(Map<Character, Integer> map) {
        int sum = 1;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character ch = entry.getKey();
            int num = entry.getValue();
            if (num > 0) {
                map.put(ch,num-1);
                sum+=count(map);
                map.put(ch,num);
            }
        }
        return sum;
    }
}
