//Time Complexity:O(n)
    {
        int large=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>large)
            {
                large=a[i];
            }
        }
        return large;
    }
    public static void main(String args[])
    {
        int A[]={78,46,24,76,96};
        System.out.println("largest value is:"+getlargest(A));
    }
}
