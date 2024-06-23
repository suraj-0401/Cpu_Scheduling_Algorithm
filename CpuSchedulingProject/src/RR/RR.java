package RR;

import Common.Process;

public class RR {

    public static void roundRobinScheduling(Process[] processes, int timeQuantum) {
        int n = processes.length;
        int[] remainingBurstTime = new int[n];
        for (int i = 0; i < n; i++) {
            remainingBurstTime[i] = processes[i].burstTime;
        }

        int currentTime = 0;
        boolean done;

        do {
            done = true;

            for (int i = 0; i < n; i++) {
                if (remainingBurstTime[i] > 0) {
                    done = false;

                    if (remainingBurstTime[i] > timeQuantum) {
                        currentTime += timeQuantum;
                        remainingBurstTime[i] -= timeQuantum;
                    } else {
                        currentTime += remainingBurstTime[i];
                        processes[i].waitingTime = currentTime - processes[i].burstTime - processes[i].arrivalTime;
                        remainingBurstTime[i] = 0;
                    }
                }
            }
        } while (!done);

        // Calculate turnaround time
        for (int i = 0; i < n; i++) {
            processes[i].turnAroundTime = processes[i].waitingTime + processes[i].burstTime;
        }
    }
}
