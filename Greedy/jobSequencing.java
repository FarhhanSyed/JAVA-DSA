//Time Complexity : O(nlogn + n*maxDeadline)
//Space Complexity : O(n+maxDeadline)
import java.util.ArrayList;
import java.util.Arrays;

public class jobSequencing {
    public static int maxSlot(int arr[])
    {
        int maxSlot=arr[0];
        for(int i=0;i<arr.length;i++)
        {   
            maxSlot=Math.max(maxSlot,arr[i]);
        }
        return maxSlot;
    }
    public static ArrayList<Integer> jobSequence(int[] deadline, int[] profit) {
        ArrayList<Integer> list=new ArrayList<>();
        int maxTimeSlot=maxSlot(deadline);
        int[] slot=new int[maxTimeSlot];
        int[][] task=new int[deadline.length][2];
        for(int i=0;i<deadline.length;i++)
        {
            task[i][0]=profit[i];
            task[i][1]=deadline[i];
        }
        Arrays.sort(task,(a,b)-> b[0]-a[0]);
        int maxJobs=0;
        int maxProfit=0;
        for(int i=0;i<deadline.length;i++)
        {
            int dead=task[i][1];
            for(int j=dead-1;j>=0;j--)
            {
                if(slot[j]==0)
                {
                    slot[j]=1;
                    maxJobs++;
                    maxProfit+=task[i][0];
                    break;
                }
            }
        }
        list.add(maxJobs);
        list.add(maxProfit);
        return list;
    }
    public static void main(String[] args) {
        int deadline[]={1,5,2,4,7,6,8,3};
        int profit[]={60,25,22,80,20,10,70,65};
        System.out.println(jobSequence(deadline, profit));
    }
}
