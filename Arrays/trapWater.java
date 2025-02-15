//Time complexity:O(n)

public class trapWater {
    public static int trap(int height[]) {
        int l = 0;
        int r = height.length - 1;
        int traappedWater = 0;
        int lmax = 0, rmax = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (lmax > height[l]) {
                    traappedWater += lmax - height[l];
                } else {
                    lmax = height[l];
                }
                l++;
            } else {
                if (rmax > height[r]) {
                    traappedWater += rmax - height[r];
                } else {
                    rmax = height[r];
                }
                r--;
            }
        }
        return traappedWater;
    }

    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        int trappedWater = trap(height);
        System.out.println(trappedWater);
    }
}



// int trappedWater = 0;
// int waterLevel;
// int leftmax[] = new int[height.length];leftmax[0]=height[0];for(
// int i = 1;i<height.length;i++)
// {
//     leftmax[i] = Math.max(leftmax[i - 1], height[i]);
// }
// int rightmax[] = new int[height.length];rightmax[height.length-1]=height[height.length-1];

// for(int i = height.length - 2;i>=0;i--)
// {
//             rightmax[i] = Math.max(height[i], rightmax[i + 1]);
//         }for(
// int i = 0;i<height.length;i++)
// {
//     waterLevel = Math.min(leftmax[i], rightmax[i]);
//     trappedWater += waterLevel - height[i];
// }return trappedWater;