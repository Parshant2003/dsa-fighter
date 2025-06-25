import java.util.*;

class Job implements Comparable<Job> {
    int deadline; // Deadline of the job
    int profit; // Profit of the job

    Job(int deadline, int profit) {
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public int compareTo(Job other) {
        int r1 = this.profit;
        int r2 = other.profit;
        return Integer.compare(r2, r1); // Sort in descending order of profit
    }
}

public class JobSequencing {

    static int getMaxProfit(Job[] jobs) {
        Arrays.sort(jobs);
        int maxDeadline = 0;
        int profit = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }
        int arr[] = new int[maxDeadline + 1]; // Array to keep track of free time slots
        Arrays.fill(arr, -1); // Initialize all slots as free (-1)
        for (Job job : jobs) {
            int jobDeadline = job.deadline;
            if (arr[jobDeadline] == -1) {
                arr[jobDeadline] = job.profit;
                profit += job.profit; // Add job profit to total profit
                // Assign job profit to the slot if it's free
            } else {
                // Find a free slot before the job's deadline
                for (int j = jobDeadline - 1; j > 0; j--) {
                    if (arr[j] == -1) {
                        arr[j] = job.profit; // Assign job profit to the first free slot found
                        profit += job.profit; // Add job profit to total profit
                        break;
                    }
                }
            }

        }
        return profit; // Return the total profit from scheduled jobs

    }

    public static void main(String[] args) {
        Job[] jobs = {
                new Job(2, 100),
                new Job(1, 50),
                new Job(2, 10),
                new Job(1, 20),
                new Job(3, 30)
        };

        int maxProfit = getMaxProfit(jobs);
        System.out.println("Max profit: " + maxProfit);
    }

}
