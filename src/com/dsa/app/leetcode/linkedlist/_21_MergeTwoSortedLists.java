package com.dsa.app.leetcode.linkedlist;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class _21_MergeTwoSortedLists {
    public static void main(String[] args) {
        int[] list1 = {1,2,4};
        ListNode list1Node = new ListNode(list1[0]);
        list1Node.next = new ListNode(list1[1]);
        list1Node = list1Node.next;
        list1Node.next = new ListNode(list1[2]);

        int[] list2 = {1,3,4};
        ListNode list2Node = new ListNode(list2[0]);
        list2Node.next = new ListNode(list2[1]);
        list2Node = list2Node.next;
        list2Node.next = new ListNode(list2[2]);

        _21_MergeTwoSortedLists obj = new _21_MergeTwoSortedLists();
        obj.mergeTwoLists(list1Node, list2Node);
    }
    ListNode compare(ListNode node1, ListNode node2)
    {
        ListNode temp = null;
        if (node1 == null || node2 == null)
        {
            if (node1 != null)
            {
                temp = node1;
            }
            else if (node2 != null)
            {
                temp = node2;
            }
        }
        else
        {
            if (node1.val <= node2.val)
            {
                temp = node1;
                node1 = node1.next;
            }
            else
            {
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
