package com.dsa.app.final450.Greedy;

import java.util.Arrays;

public class _2_JobSequencingProblem {
    public static void main(String[] args) {
        _2_JobSequencingProblem program = new _2_JobSequencingProblem();
        int[][] jobs = {{1, 2, 100}, {2, 1, 19}, {3, 2, 27}, {4, 1, 25}, {5, 3, 15}};
        int timeSlots = 4;
        program.maximumNumberOfMeetingsPossible(jobs, timeSlots);
    }

    private void maximumNumberOfMeetingsPossible(int[][] input, int timeSlots) {
        Job[] jobs = new Job[input.length];
        for (int index = 0; index < jobs.length; index++) {
            jobs[index] = new Job(input[index][0], input[index][1], input[index][2]);
        }

        Arrays.sort(jobs);

        boolean[] timeSlotsFilled = new boolean[timeSlots];
        int[] jobsScheduled = new int[timeSlots];

        for (int index = 0; index < jobs.length; index++) {
            //Start with the minimum of the deadline or available time slot.
            for (int timeSlotIndex = Math.min(timeSlots - 1, jobs[index].deadline - 1); timeSlotIndex >= 0; timeSlotIndex--) {
                if (timeSlotsFilled[timeSlotIndex] == false) {
                    timeSlotsFilled[timeSlotIndex] = true;
                    jobsScheduled[timeSlotIndex] = jobs[index].jobId;
                    break;
                }
            }
        }

        for (int jb : jobsScheduled)
            System.out.print(jb + " ");
        System.out.println();
    }
}

class Job implements Comparable<Job> {
    int jobId;
    int deadline;
    int profit;

    public Job(int jobId, int deadline, int profit) {
        this.jobId = jobId;
        this.deadline = deadline;
        this.profit = profit;
    }


    @Override
    public int compareTo(Job o) {
        return o.profit - this.profit;
    }
}
