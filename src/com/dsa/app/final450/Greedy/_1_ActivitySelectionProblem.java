package com.dsa.app.final450.Greedy;

import java.util.Arrays;

/* Implemented using the longest increasing subsequence.*/
public class _1_ActivitySelectionProblem {
    public static void main(String[] args) {
        _1_ActivitySelectionProblem program = new _1_ActivitySelectionProblem();
        int[] start1 = {1, 3, 0, 5, 8, 5};
        int[] end1 = {2, 4, 6, 7, 9, 9};

        int[] start2 = {10, 12, 20};
        int[] end2 = {20, 25, 30};
        program.maximumNumberOfMeetingsPossible(start1, end1);
    }

    private void maximumNumberOfMeetingsPossible(int[] start, int[] end) {
        Meeting[] meetingArr = new Meeting[start.length];
        for (int index = 0; index < start.length; index++) {
            meetingArr[index] = new Meeting(start[index], end[index]);
        }

        Arrays.sort(meetingArr);

        System.out.print("Following activities are selected : ");

        int prevActivitySelected = 0;
        System.out.print(prevActivitySelected + " ");

        for (int currentMeetingIndex = 1; currentMeetingIndex < meetingArr.length; currentMeetingIndex++) {
            if (meetingArr[currentMeetingIndex].start >= meetingArr[prevActivitySelected].end) {
                prevActivitySelected = currentMeetingIndex;
                System.out.print(prevActivitySelected + " ");
            }
        }
    }

}

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.end != o.end)
            return this.end - o.end;
        else
            return this.start - o.start;
    }
}
