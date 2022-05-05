package com.dsa.app.level1.linkedlists;

public class _4_OtherLLFunctions {

    public static void main(String[] args) {

    }

    private int findKthElement(LinkedListDS linkedList, int k) {
        Node slow = linkedList.getHead();
        Node fast = linkedList.getHead();

        int currentIndex = 0;
        while (currentIndex < k) {
            fast = fast.getNext();
        }

        while (fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        return slow.getData();
    }

    private int findMiddleElement(LinkedListDS linkedList) {
        Node slow = linkedList.getHead();
        Node fast = linkedList.getHead();

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow.getData();
    }

    private Node merge2SortedLinkedLists(LinkedListDS linkedList1, LinkedListDS linkedList2) {
        Node first = linkedList1.getHead();
        Node second = linkedList2.getHead();
        Node third = null;
        Node last = null;

        if (first.getData() < second.getData()) {
            third = last = first;
            first = first.getNext();
            last.setNext(null);
        } else if (first.getData() > second.getData()) {
            third = last = second;
            second = second.getNext();
            last.setNext(null);
        }

        while (first != null && second != null) {
            if (first.getData() < second.getData()) {
                last.setNext(first);
                last = first;
                first = first.getNext();
                last.setNext(null);
            } else if (first.getData() > second.getData()) {
                last.setNext(second);
                last = second;
                second = second.getNext();
                last.setNext(null);
            }
        }

        if (first != null) {
            last.setNext(first);
        }

        if (second != null) {
            last.setNext(second);
        }

        return third;
    }

    public static LinkedListDS mergeTwoSortedLists(LinkedListDS l1, LinkedListDS l2) {
        Node one = l1.getHead();
        Node two = l2.getHead();
        LinkedListDS res = new LinkedListDS();
        while (one != null && two != null) {
            if (one.getData() < two.getData()) {
                res.addLast(one.getData());
                one = one.getNext();
            } else {
                res.addLast(two.getData());
                two = two.getNext();
            }
        }
        while (one != null) {
            res.addLast(one.getData());
            one = one.getNext();
        }
        while (two != null) {
            res.addLast(two.getData());
            two = two.getNext();
        }
        return res;
    }

    private LinkedListDS mergeSort(Node head, Node tail) {
        if (head == tail) {
            LinkedListDS result = new LinkedListDS();
            result.addLast(head.getData());
            return result;
        }
        Node mid = midNode(head, tail);
        LinkedListDS left = mergeSort(head, mid);
        LinkedListDS right = mergeSort(mid.getNext(), tail);
        LinkedListDS finalList = mergeTwoSortedLists(left, right);
        return finalList;
    }

    private Node midNode(Node head, Node tail) {
        Node slow = head;
        Node fast = head;

        while (fast.getNext() != tail && fast.getNext().getNext() != tail) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    private void removeDuplicates(LinkedListDS linkedList) {
        Node head = linkedList.getHead();
        while (head != null && head.getNext() != null) {
            if (head.getData() == head.getNext().getData()) {
                head.setNext(head.getNext().getNext());
            }
            head = head.getNext();
        }
    }


}
