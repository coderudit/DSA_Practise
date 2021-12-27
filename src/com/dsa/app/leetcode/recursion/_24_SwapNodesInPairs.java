package com.dsa.app.leetcode.recursion;

public class _24_SwapNodesInPairs {
    public static void main(String[] args) {
        var lstnode1 = new ListNode(1);
        var lstnode2 = new ListNode(2);
        var lstnode3 = new ListNode(3);
        var lstnode4 = new ListNode(4);
        lstnode3.next = lstnode4;
        lstnode2.next = lstnode3;
        lstnode1.next = lstnode2;
        var mainHead = swapPairs(lstnode1);
        System.out.println(lstnode1);
    }
    public static ListNode swapPairs(ListNode head) {
        if(head != null && head.next != null){
            ListNode temp = head;
            head = head.next;
            temp.next = head.next;
            head.next = temp;
            head.next.next = swapPairs(head.next.next);
        }
        return head;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
