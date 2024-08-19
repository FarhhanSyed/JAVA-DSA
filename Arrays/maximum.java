import java.util.*;
public class maximum {
    public static int getlargest(int a[])
    {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>max)
            {
                max=a[i];
            }
        }
        return max;
    }
    public static void main(String args[])
    {
        int A[]={78,46,24,76,96};
        System.out.println("largest value is:"+getlargest(A));
    }
}
