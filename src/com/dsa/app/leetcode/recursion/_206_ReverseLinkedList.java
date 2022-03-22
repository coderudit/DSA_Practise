package com.dsa.app.leetcode.recursion;

public class _206_ReverseLinkedList {
    public static void main(String[] args) {
        var lstnode1 = new ListNode(1);
        var lstnode2 = new ListNode(2);
        var lstnode3 = new ListNode(3);
        var lstnode4 = new ListNode(4);
        lstnode3.next = lstnode4;
        lstnode2.next = lstnode3;
        lstnode1.next = lstnode2;
        var mainHead = reverseList(lstnode1);
        System.out.println(lstnode1);
    }

    private static ListNode reverseList(ListNode head) {
        ListNode q = null;
        while (head.next != null) {
            var temp = head.next;
            head.next = q;
            q= head;
            head = temp;
        }
        return head;
    }
}

