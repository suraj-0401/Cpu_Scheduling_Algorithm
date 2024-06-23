package SJN;

import Common.Process;

import java.util.Arrays;
import java.util.Comparator;

public class SJN {

    public static void sjnScheduling(Process[] processes) {
        int n = processes.length;
        Process[] sortedByArrival = Arrays.copyOf(processes, n);
        Arrays.sort(sortedByArrival, Comparator.comparingInt(p -> p.arrivalTime));

        int currentTime = 0;
        int completed = 0;
        boolean[] isCompleted = new boolean[n];

        while (completed != n) {
            int idx = -1;
            int minBurstTime = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (sortedByArrival[i].arrivalTime <= currentTime && !isCompleted[i] && sortedByArrival[i].burstTime < minBurstTime) {
                    minBurstTime = sortedByArrival[i].burstTime;
                    idx = i;
                }
            }

            if (idx != -1) {
                sortedByArrival[idx].waitingTime = currentTime - sortedByArrival[idx].arrivalTime;
                currentTime += sortedByArrival[idx].burstTime;
                sortedByArrival[idx].turnAroundTime = sortedByArrival[idx].waitingTime + sortedByArrival[idx].burstTime;
                isCompleted[idx] = true;
                completed++;
            } else {
                currentTime++;
            }
        }

        System.arraycopy(sortedByArrival, 0, processes, 0, n);
    }
}
