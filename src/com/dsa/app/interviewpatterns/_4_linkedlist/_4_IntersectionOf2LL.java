package com.dsa.app.interviewpatterns._4_linkedlist;

public class _4_IntersectionOf2LL {
    public _1_RemoveLinkedListElements.ListNode getIntersectionNode(_1_RemoveLinkedListElements.ListNode headA, _1_RemoveLinkedListElements.ListNode headB) {
        _1_RemoveLinkedListElements.ListNode nodeA = headA;
        _1_RemoveLinkedListElements.ListNode nodeB = headB;

        while(nodeA != nodeB){
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }

        return nodeA;
    }
}
