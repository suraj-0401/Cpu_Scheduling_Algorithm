package Common;

public class Process {
	public int processId;
	public int arrivalTime;
	public int burstTime;
	public int waitingTime;
	public int turnAroundTime;
	public int priority;// Default value, ignored if not using priority scheduling 
	public Process(int processId,int burstTime,int arrivalTime){
		this.processId=processId;
		this.burstTime=burstTime;
		this.arrivalTime=arrivalTime;
		this.waitingTime=0;
		this.turnAroundTime=0;
		this.priority=0;
	}
	public Process(int processId,int burstTime,int arrivalTime,int priority){
		this(processId,burstTime,arrivalTime);
		this.priority=priority;
	}
	 public int getProcessId() {
	        return processId;
	    }

	    public int getWaitingTime() {
	        return waitingTime;
	    }

	    public int getTurnAroundTime() {
	        return turnAroundTime;
	    }
}
