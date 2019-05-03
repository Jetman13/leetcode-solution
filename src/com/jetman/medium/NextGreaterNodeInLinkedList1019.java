package src.com.jetman.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: za-graphene-anan
 * @description: https://leetcode-cn.com/problems/next-greater-node-in-linked-list/
 * @author: za-zhangmin
 * @create: 2019-04-05 15:31
 **/
public class NextGreaterNodeInLinkedList1019 {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] nextLargerNodes(ListNode head) {

        List<Integer> ansList = new ArrayList<Integer>();

        ListNode pre = null;
        ListNode first = null;
        while (head != null) {
            if (pre != null && head.val >= pre.val) {
                if (pre.val == 0) {

                } else {
                    first = findFirst(first, head.val);
                }
            } else {
                first = findFirst(head.next, head.val);
            }
            if (first == null) {
                ansList.add(0);
            } else {
                ansList.add(first.val);
            }
            pre = head;
            head = head.next;
        }
        
        return ansList.stream().mapToInt(Integer::intValue).toArray();

    }

    private ListNode findFirst(ListNode head, int val) {

        while (head != null) {
            if (head.val > val) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
