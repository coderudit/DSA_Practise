package com.dsa.app.interviewpatterns._4_linkedlist;

public class _5_Add2Numbers {
    public static void main(String[] args) {
        _5_Add2Numbers problem = new _5_Add2Numbers();
        //problem.addTwoNumbers()
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode l3 = head; //Head is kept as sentinel node, if we don't keep it last node will result in 0 and we have to write extra code for that.
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            l3.next = new ListNode(sum % 10);
            carry = sum / 10;
            l3 = l3.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0)
            l3.next = new ListNode(carry);
        return head.next;
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
}
