public class jumpGameII {
    public static int jumpGame(int[] arr)
    {
        int l=0;
        int r=0;
        int jumps=0;
        while(r<arr.length-1)
        {
            int farthest=0;
            for(int i=l;i<=r;i++)
            {
                farthest=Math.max(farthest,arr[i]+i);
            }
            l=r+1;
            r=farthest;
            jumps++;
        }
        return jumps;
    }
    public static void main(String[] args) {
        int[] arr={2,3,1,1,4};
        System.out.println(jumpGame(arr));
    }
}
