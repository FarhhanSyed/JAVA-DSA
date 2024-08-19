import java.util.*;
public class LinearSearch {
    public static int linear(int A[],int k)
    {
        int i;
        for(i=0;i<A.length;i++)
        {
            if(A[i]==k)
            {
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[])
    {
        int arr[]={32,92,52,62,12};
        int k=12;
        int index=linear(arr, k);
        if(index!=-1)
        {
            System.out.println("key is at index:"+index);
        }
        else{
            System.out.println("key not found");
        }
    }
}
