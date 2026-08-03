/* 
    You are given N jobs. Each job has  ->    { Job ID , Deadline , Profit }
                                    
    Each job takes exactly 1 unit of time to complete.
    You can perform only one job at a time, and a job earns its profit only if it is completed on or before its deadline.

*   Goal  ->  Find a schedule of jobs that maximizes the total profit.

    Example:
            Jobs:
            A → Deadline = 2, Profit = 100
            B → Deadline = 1, Profit = 19
            C → Deadline = 2, Profit = 27
            D → Deadline = 1, Profit = 25
            E → Deadline = 3, Profit = 15

    Output:  Maximum Profit = 142   ->    Jobs = C, A, E

    Because they can be scheduled as:
    Time:  1   2   3
           C   A   E

*   APPROACH ->
    Sort the jobs in descending order of profit. First take jobs with HIGHER PROFIT (Greedy Approach)
    If the maximum deadline is x, create an array of size x. Initialize each array index to -1 to represent that no jobs have been performed yet.
    For each job, check if it can be performed on its last day(deadline day), Because earlier days are more valuable to jobs with smaller deadlines.
    If the job can be performed on its last day, mark that index with the job ID and add the profit to the total.
    If the job cannot be performed on its last day, loop through the previous indexes(days) to find an empty slot and schedule the job there.

*/
import java.util.*;

class Job {
    int id;
    int deadline;
    int profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class Job_Sequencing_Problem {
    public static int[] jobScheduling(Job[] jobs) {

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);                  // *Sort jobs by profit in descending order9(- is used to sort in descending)
        int maxDeadline = 0;                                               // Find maximum deadline

        for (Job maxi : jobs) {
            maxDeadline = Math.max(maxDeadline, maxi.deadline);            // *Use maxi.deadline to play a loop in deadline of jobs[] arrayy
        }
        boolean[] slot = new boolean[maxDeadline + 1];                     // Create time slots

        int countJobs = 0;
        int totalProfit = 0;

//      Now, For every job, start from its deadline and move backward until you find an empty slot. Schedule it there.

        for (Job CurrJob : jobs) {                                      // Go through every sorted job one by one
            for (int time = CurrJob.deadline; time >= 1; time--) {      // *Try to place current job as late as possible(start from its deadline)

                if (!slot[time]) {                                    // Is deadline time slot empty? (All slots are initially assigned false, means empty)
                    slot[time] = true;                                // If yes, we can put our job there.(true shows that now the slot is occupied)
                    countJobs++;                                      // successfully scheduled one job.
                    totalProfit += CurrJob.profit;                    // Add the current job profit
                    break;                                            // break the loop and move to next job
                }
            }
        }
        return new int[]{countJobs, totalProfit};                     // return new array containing only tota jobs sequenced && total profit gain
    }

    public static void main(String[] args) {

        Job[] jobs = {
            new Job(1, 4, 20),
            new Job(2, 1, 10),
            new Job(3, 2, 40),
            new Job(4, 2, 30)
        };

        int[] ans = jobScheduling(jobs);

        System.out.println("Jobs: " + ans[0]);
        System.out.println("Profit: " + ans[1]);
    }
}