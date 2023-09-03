public class process implements Comparable<process>{
    String processName ;
    int arrivalTime;
    int ExecutionTime;
    public process(String processName ,int arrivalTime ,int ExecutionTime)
    {
        this.processName=processName;
        this.arrivalTime=arrivalTime;
        this.ExecutionTime=ExecutionTime;
    }
    @Override
    public int compareTo(process process)
    {
        return Integer.compare(this.arrivalTime, process.arrivalTime);
    }
    @Override
    public String toString()
    {
        return "Process :"+this.processName+" arrived at :"+this.arrivalTime+" and has execution time of: "+this.ExecutionTime;
    }
}
