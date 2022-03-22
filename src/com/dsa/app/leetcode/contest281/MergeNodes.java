package com.dsa.app.leetcode.contest281;

public class MergeNodes {
    public static void main(String[] args) {
        ListNode last = new ListNode(0);
        ListNode seven = new ListNode(2, last);
        ListNode six = new ListNode(5, seven);
        ListNode five = new ListNode(4, six);
        ListNode four = new ListNode(0, five);
        ListNode three = new ListNode(1, four);
        ListNode two = new ListNode(3, three);
        ListNode root = new ListNode(0, two);
        MergeNodes obj = new MergeNodes();
        obj.mergeNodes(root);

    }

    public ListNode mergeNodes(ListNode head) {
        ListNode prev = head;
        ListNode mainHead = prev;
        mainHead = prev;

        ListNode current = head.next;

        int currentSum = 0;
        while (current != null) {
            if (current.val != 0) {
                //add to sum
                currentSum += current.val;
                current = current.next;
            } else {
                //add previous sum
                prev.val = currentSum;
                currentSum = 0;
                if (current.next != null) {
                    prev.next = current;
                    prev = current;
                }else{
                    prev.next = null;
                }
                current = current.next;
            }
        }
        return mainHead;
    }
}

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
