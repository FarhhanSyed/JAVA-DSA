public class jumpGameI{
    public static boolean jumpGame(int[] arr)
    {
        int maxJump=0;
        int i=0;
        while(i<arr.length)
        {
            if(i>maxJump)
            {
                return false;
            }
            maxJump=Math.max(maxJump,arr[i]+i);
            i++;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr={2,3,1,0,4};
        System.out.println(jumpGame(arr));
    }
}