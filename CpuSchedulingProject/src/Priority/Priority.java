package Priority;

import Common.Process;
import FCFS.FCFS;

import java.util.Arrays;
import java.util.Comparator;

public class Priority {

    public static void priorityScheduling(Process[] processes) {
        int n = processes.length;
        Arrays.sort(processes, Comparator.comparingInt(p -> p.priority));

        FCFS.fcfsScheduling(processes);
    }
}
