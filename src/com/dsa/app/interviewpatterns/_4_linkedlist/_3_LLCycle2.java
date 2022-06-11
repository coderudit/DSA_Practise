package com.dsa.app.interviewpatterns._4_linkedlist;

public class _3_LLCycle2 {
    public static void main(String[] args) {

    }

    public _1_RemoveLinkedListElements.ListNode detectCycle(_1_RemoveLinkedListElements.ListNode head) {
        _1_RemoveLinkedListElements.ListNode start = head;
        _1_RemoveLinkedListElements.ListNode meet = head;
        meet = hasCycle(meet);

        if (meet == null)
            return null;

        while (start != meet) {
            start = start.next;
            meet = meet.next;
        }

        return start;
    }

    _1_RemoveLinkedListElements.ListNode hasCycle(_1_RemoveLinkedListElements.ListNode head) {
        _1_RemoveLinkedListElements.ListNode slow = head;
        _1_RemoveLinkedListElements.ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return slow;

        }

        return null;
    }
}
