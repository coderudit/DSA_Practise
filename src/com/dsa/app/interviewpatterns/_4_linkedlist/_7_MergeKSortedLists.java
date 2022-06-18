package com.dsa.app.interviewpatterns._4_linkedlist;

public class _7_MergeKSortedLists {
    public static void main(String[] args) {

    }

    public _6_Merge2SortedLists.ListNode mergeKLists(_6_Merge2SortedLists.ListNode[] lists) {
        _6_Merge2SortedLists merge = new _6_Merge2SortedLists();

        int currListLength = lists.length - 1;

        while(currListLength != 0){
            int start = 0;
            int end = currListLength;

            while (start < end){

                lists[start] = merge.Merge2SortedListIteratively(lists[start], lists[end]);

                start++;
                end--;

                if(start >= end)
                    currListLength = end;
            }
        }

        return lists[0];
    }
}
