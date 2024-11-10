//2 pointer Approach-O(n)

import java.util.ArrayList;

public class containerwithMostWater {
    public static int storeWater(ArrayList<Integer> list) {
        int maxWater = Integer.MIN_VALUE;
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            int ht = Math.min(list.get(i), list.get(j));
            int wd = j - i;
            int curWater = ht * wd;
            maxWater = Math.max(curWater, maxWater);
            if (list.get(i) < list.get(j)) {
                i++;
            } else {
                j--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);
        System.out.println(storeWater(list));
    }
}

// brute force method-O(n^2)
// for(int i=0;i<list.size()-1;i++)
// {
// for(int j=i+1;j<list.size();j++)
// {
// int ht=Math.min(list.get(i),list.get(j));
// int wd=j-i;
// int curWater=ht*wd;
// maxWater=Math.max(curWater,maxWater);
// }
// }
