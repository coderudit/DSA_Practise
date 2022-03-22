package com.dsa.app.leetcode.linkedlist;

import java.util.ArrayDeque;
import java.util.Arrays;

public class _23_MergeKSortedLists {
    public static void main(String[] args) {
        int[] list1 = {1, 2, 4};
        ListNode list1Node = new ListNode(list1[0]);
        list1Node.next = new ListNode(list1[1]);
        list1Node = list1Node.next;
        list1Node.next = new ListNode(list1[2]);

        int[] list2 = {1, 3, 4};
        ListNode list2Node = new ListNode(list2[0]);
        list2Node.next = new ListNode(list2[1]);
        list2Node = list2Node.next;
        list2Node.next = new ListNode(list2[2]);

        _23_MergeKSortedLists obj = new _23_MergeKSortedLists();
        obj.mergeTwoLists(list1Node, list2Node);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ArrayDeque<ListNode> queue = new ArrayDeque<>(Arrays.stream(lists).toList());

        while(queue.size() > 2){
            var list1 = queue.removeFirst();
            var list2 = queue.removeFirst();
            queue.addLast(compare(list1, list2));
        }
        return queue.removeFirst();
    }


    ListNode compare(ListNode node1, ListNode node2) {
        ListNode temp = null;
        if (node1 == null || node2 == null) {
            if (node1 != null) {
                temp = node1;
            } else if (node2 != null) {
                temp = node2;
            }
        } else {
            if (node1.val <= node2.val) {
                temp = node1;
                node1 = node1.next;
            } else {
                temp = node2;
                node2 = node2.next;
            }
            temp.next = compare(node1, node2);
        }
        return temp;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = compare(list1, list2);  // comapre resturns the reference for the node
        // having lesser value
        return head;
    }

}
