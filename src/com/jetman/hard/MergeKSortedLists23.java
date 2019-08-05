package src.com.jetman.hard;

import src.com.jetman.base.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * @author: Jetman
 * @create: 2019-04-18 21:08
 **/
public class MergeKSortedLists23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, (o1,o2) -> (o1.val - o2.val));


        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
            queue.add(lists[i]);
        }

        ListNode head = new ListNode(-1);
        ListNode go = head;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            go.next = node;
            go = go.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return head.next;
    }
}
