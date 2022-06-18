package com.dsa.app.interviewpatterns._4_linkedlist;

import java.util.LinkedList;
import java.util.List;

public class _6_Merge2SortedLists {
    public static void main(String[] args) {

    }

    public ListNode Merge2SortedListsRecursively(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;

        else if (l1.val <= l2.val) {
            l1.next = Merge2SortedListsRecursively(l1.next, l2);
            return l1;
        } else {
            l2.next = Merge2SortedListsRecursively(l1, l2.next);
            return l2;
        }
    }

    public ListNode Merge2SortedListIteratively(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(-1);
        ListNode current = sentinel;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = l1 == null ? l2 : l1;
        return sentinel.next;
    }

    public class ListNode {
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
}
