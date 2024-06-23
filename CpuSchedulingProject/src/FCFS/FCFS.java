package FCFS;

import Common.CPUSchedulingVisualization;
import Common.Process;

import java.util.Arrays;
import java.util.Comparator;

public class FCFS {

    public static void fcfsScheduling(Process[] processes) {
        int n = processes.length;
        Arrays.sort(processes, Comparator.comparingInt(p -> p.arrivalTime));
        processes[0].waitingTime = 0;

        // Calculate waiting time
        for (int i = 1; i < n; i++) {
            processes[i].waitingTime = Math.max(0, processes[i - 1].waitingTime + processes[i - 1].burstTime - processes[i].arrivalTime);
            if (processes[i].waitingTime < 0) {
                processes[i].waitingTime = 0;
            }
        }

        // Calculate turnaround time
        for (int i = 0; i < n; i++) {
            processes[i].turnAroundTime = processes[i].waitingTime + processes[i].burstTime;
        }
        
       }
}
