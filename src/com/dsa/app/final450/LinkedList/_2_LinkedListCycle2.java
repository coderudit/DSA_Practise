package com.dsa.app.final450.LinkedList;

public class _2_LinkedListCycle2 {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode start = head;
        ListNode meet = head;
        meet = hasCycle(meet);

        if(meet == null)
            return null;

        while(start != meet) {
            start = start.next;
            meet = meet.next;
        }

        return start;
    }

    ListNode hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return slow;

        }

        return null;
    }
}
