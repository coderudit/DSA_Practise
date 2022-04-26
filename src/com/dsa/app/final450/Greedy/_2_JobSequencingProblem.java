package com.dsa.app.final450.Greedy;

import java.util.Arrays;

public class _2_JobSequencingProblem {
    public static void main(String[] args) {
        _2_JobSequencingProblem program = new _2_JobSequencingProblem();
        int[][] jobs = {{1,4,20},{2,1,10},{3,1,40},{4,1,30}};
        program.maximumNumberOfMeetingsPossible(jobs);
    }

    private void maximumNumberOfMeetingsPossible(int[][] input) {
        Job[] jobs = new Job[input.length];
        for (int index = 0; index < jobs.length; index++) {
            jobs[index] = new Job(input[index][0], input[index][1], input[index][2]);
        }

        Arrays.sort(jobs);

        int[] dp = new int[jobs.length];
        int[] dpProfit  = new int[jobs.length];
        int overallProfit = 0;
        int overallJobs = 0;
        for (int currentJobIndex = 0; currentJobIndex < jobs.length; currentJobIndex++) {
            int profit = jobs[currentJobIndex].profit;
            int numJobs = 0;
            for (int previousJobIndex = 0; previousJobIndex < currentJobIndex; previousJobIndex++) {
                if (jobs[previousJobIndex].profit > jobs[currentJobIndex].profit && dp[previousJobIndex] >= numJobs) {
                    numJobs = dp[previousJobIndex];
                    profit += dpProfit[previousJobIndex];
                }
            }
            dp[currentJobIndex] = numJobs + 1;
            dpProfit[currentJobIndex] = profit;
            overallJobs = Math.max(overallJobs, dp[currentJobIndex]);
            overallProfit = Math.max(overallProfit, dpProfit[currentJobIndex]);
        }
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
        if (this.deadline != o.deadline)
            return this.deadline - o.deadline;
        else
            return this.profit - o.profit;
    }
}
