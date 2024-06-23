package Main;

import Common.Process;
import Common.CPUSchedulingVisualization;
import FCFS.FCFS;
import SJN.SJN;
import RR.RR;
import Priority.Priority;

import java.util.Scanner;
import javafx.application.Application;

public class CPUScheduling {

    private static Process[] processes;
    private static int choice;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();

        processes = new Process[n];

        System.out.println("\nChoose a Scheduling Algorithm:");
        System.out.println("1. First-Come, First-Served (FCFS)");
        System.out.println("2. Shortest Job Next (SJN)");
        System.out.println("3. Round Robin (RR)");
        System.out.println("4. Priority Scheduling");
        choice = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter burst time for process " + (i + 1) + ": ");
            int burstTime = sc.nextInt();
            System.out.print("Enter arrival time for process " + (i + 1) + ": ");
            int arrivalTime = sc.nextInt();

            if (choice == 4) { // Priority Scheduling
                System.out.print("Enter priority for process " + (i + 1) + ": ");
                int priority = sc.nextInt();
                processes[i] = new Process(i + 1, burstTime, arrivalTime, priority);
            } else {
                processes[i] = new Process(i + 1, burstTime, arrivalTime);
            }
        }

        switch (choice) {
            case 1:
                FCFS.fcfsScheduling(processes);
                CPUSchedulingVisualization.setAlgorithmName("FCFS");
                break;
            case 2:
                SJN.sjnScheduling(processes);
                CPUSchedulingVisualization.setAlgorithmName("SJN");
                break;
            case 3:
                System.out.print("Enter the time quantum for Round Robin: ");
                int timeQuantum = sc.nextInt();
                RR.roundRobinScheduling(processes, timeQuantum);
                CPUSchedulingVisualization.setAlgorithmName("Round Robin");
                break;
            case 4:
                Priority.priorityScheduling(processes);
                CPUSchedulingVisualization.setAlgorithmName("Priority Scheduling");
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        printResults();
        visualizeResults();  // Added method call for visualization
    }

    private static void printResults() {
        System.out.println("\nProcess ID\tBurst Time\tArrival Time\tWaiting Time\tTurnaround Time\tPriority");

        for (Process process : processes) {
            System.out.printf("%9d\t%10d\t%12d\t%12d\t%16d\t%8d\n",
                    process.processId, process.burstTime, process.arrivalTime,
                    process.waitingTime, process.turnAroundTime,
                    (choice == 4 ? process.priority : -1));
        }

        double totalWaitingTime = 0;
        double totalTurnaroundTime = 0;

        for (Process process : processes) {
            totalWaitingTime += process.waitingTime;
            totalTurnaroundTime += process.turnAroundTime;
        }

        System.out.printf("\nAverage Waiting Time: %.2f\n", totalWaitingTime / processes.length);
        System.out.printf("Average Turnaround Time: %.2f\n", totalTurnaroundTime / processes.length);
    }

    private static void visualizeResults() {
        CPUSchedulingVisualization.setProcesses(processes);
        Application.launch(CPUSchedulingVisualization.class);
    }
}
