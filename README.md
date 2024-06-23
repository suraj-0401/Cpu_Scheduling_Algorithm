# CPU-Scheduling-Algorithms
This repository contains a Java-based CPU scheduler simulation project.
# Documentation
The project's structure is organized as follows:
# src
Process:Represents the data of each process, such as start time and burst time.
CPU: Represents the CPU for simulating the schedule.
Scheduler: Abstract class for primitive methods and fields.
FCFS: First Come First Serve Scheduler.
SJN: Shortest Job Next Scheduler (can be preemptive).
Priority: Priority Scheduler (can be preemptive).
RR: Round Robin Scheduler.

# Getting Started
To run the simulation, you can directly run the FXMLDocumentController class. This will launch the main GUI, where you can input the processes and select the scheduling algorithm to simulate.

# Sample Output
Enter the number of processes: 3

Choose a Scheduling Algorithm:
1. First-Come, First-Served (FCFS)
2. Shortest Job Next (SJN)
3. Round Robin (RR)
4. Priority Scheduling
4
Enter burst time for process 1: 5
Enter arrival time for process 1: 2
Enter priority for process 1: 3
Enter burst time for process 2: 1
Enter arrival time for process 2: 4
Enter priority for process 2: 3
Enter burst time for process 3: 3
Enter arrival time for process 3: 2
Enter priority for process 3: 3

Process ID	Burst Time	Arrival Time	Waiting Time	Turnaround Time	Priority
        1	         5	           2	           0	               5	       3
        3	         3	           2	           3	               6	       3
        2	         1	           4	           2	               3	       3

Average Waiting Time: 1.67
Average Turnaround Time: 4.67

 # Visulization 
 


