import java.util.*;
public class scheduler
{
    public static String Scheduler_FCFS(String input)
    {
        String output="";
        String processName = input.split(";")[0];
        String[] processNameList =processName.split(",");
        String arrivalTime = input.split(";")[1];
        String[] arrivalTimeList =arrivalTime.split(",");
        String ExecutionTime = input.split(";")[2];
        String[] ExecutionTimeList =ExecutionTime.split(",");
        ArrayList<process> processList= new ArrayList<process>();
        for(int i =0;i<processNameList.length;i++)
        {
            processList.add(new process(processNameList[i],Integer.parseInt(arrivalTimeList[i]),Integer.parseInt(ExecutionTimeList[i])));
        }
        Collections.sort(processList);
        for(int i =0 ;i<processList.size();i++)
        {
            if(i==processList.size()-1)
            {
                output = output + processList.get(i).processName+"("+processList.get(i).ExecutionTime+")";
            }
            else
            {
                output = output + processList.get(i).processName + "(" + processList.get(i).ExecutionTime + "),";
            }
        }
        return "Scheduler_FCFS(input) = "+output;
    }
    public static String Scheduler_SJF(String input)
    {
        int timeElapsed=0;
        String output="";
        String processName = input.split(";")[0];
        String[] processNameList =processName.split(",");
        String arrivalTime = input.split(";")[1];
        String[] arrivalTimeList =arrivalTime.split(",");
        String ExecutionTime = input.split(";")[2];
        String[] ExecutionTimeList =ExecutionTime.split(",");
        ArrayList<process> processList= new ArrayList<process>();
        for(int i =0;i<processNameList.length;i++)
        {
            processList.add(new process(processNameList[i],Integer.parseInt(arrivalTimeList[i]),Integer.parseInt(ExecutionTimeList[i])));
        }
        Collections.sort(processList);
        while(!(processList.isEmpty()))
        {
            process min = processList.get(0);
            for(process i :processList)
            {
                if(!(i.arrivalTime>timeElapsed))
                {
                    if(i.ExecutionTime < min.ExecutionTime)
                    {
                        min= i;
                    }
                }
            }
            if(processList.size()==1)
            {
                output = output.concat(min.processName+"("+min.ExecutionTime+")");
            }
            else
            {
                output = output.concat(min.processName+"("+min.ExecutionTime+"),");
            }
            timeElapsed += min.ExecutionTime;
            processList.remove(min);
        }
        return "Scheduler_SJF(input) = "+output;
    }
    public static String Scheduler_RR(String input)
    {
        int timeElapsed=0;
        int numberOfCycles=0;
        String output="";
        ArrayList<String> outputTemp= new ArrayList<String>();
        String processName = input.split(";")[0];
        String[] processNameList =processName.split(",");
        String arrivalTime = input.split(";")[1];
        String[] arrivalTimeList =arrivalTime.split(",");
        String ExecutionTime = input.split(";")[2];
        String[] ExecutionTimeList =ExecutionTime.split(",");
        ArrayList<process> processList= new ArrayList<process>();
        for(int i =0;i<processNameList.length;i++)
        {
            processList.add(new process(processNameList[i],Integer.parseInt(arrivalTimeList[i]),Integer.parseInt(ExecutionTimeList[i])));
        }
        Collections.sort(processList);
        Queue<process> runningProcessList = new LinkedList<process>();
        runningProcessList.add(processList.get(0));
        while(!(runningProcessList.isEmpty()))
        {
            process currentRunningProcess = runningProcessList.remove();
            if (currentRunningProcess.ExecutionTime>=2)
            {
                outputTemp.add(currentRunningProcess.processName + "(" + 2 + ")");
                timeElapsed+=2;
                currentRunningProcess.ExecutionTime-=2;
                numberOfCycles+=2;
            }
            else if(currentRunningProcess.ExecutionTime==1)
            {
                timeElapsed+=1;
                currentRunningProcess.ExecutionTime-=1;
                outputTemp.add(currentRunningProcess.processName + "(" + 1 + ")");
            }
            for (process i :processList)
            {
                if(i.arrivalTime<=timeElapsed && !(runningProcessList.contains(i)) && i.ExecutionTime>0&& !(i.equals(currentRunningProcess)))
                {
                    runningProcessList.add(i);
                }
            }
            if(numberOfCycles==2)
            {
                runningProcessList.add(currentRunningProcess);
                numberOfCycles=0;
            }
        }
        for (int i =0; i<outputTemp.size();i++)
        {
            output = output + outputTemp.get(i);
            if(i<outputTemp.size()-1)
            {
                output=output+",";
            }
        }
        return "Scheduler_SJF(input) = " + output;
    }
    public static void main(String[] args)
    {
        //"A,B,C,D,E;0,2,4,5,8;3,6,4,5,2"
        System.out.println(Scheduler_FCFS("A,B,C,D,E;0,2,4,5,8;3,6,4,5,2"));
        System.out.println(Scheduler_SJF("A,B,C,D,E;0,2,4,5,8;3,6,4,5,2"));
        System.out.println(Scheduler_RR("A,B,C,D,E;0,2,4,5,8;3,6,4,5,2"));
        //"Hi,Bye;0,0;4,2"
        System.out.println(Scheduler_FCFS("Hi,Bye;0,0;4,2"));
        System.out.println(Scheduler_SJF("Hi,Bye;0,0;4,2"));
        System.out.println(Scheduler_RR("Hi,Bye;0,0;4,2"));
    }
}
