/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

public class findinMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peak(mountainArr);
        int first = binary(mountainArr, 0, peak, target);
        if (first != -1) {
            return binary(mountainArr, 0, peak, target);
        }
        return binary(mountainArr, peak + 1, mountainArr.length() - 1, target);
    }

    public static int peak(MountainArray mountainArr) {
        int s = 0;
        int e = mountainArr.length() - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    public static int binary(MountainArray mountainArr, int s, int e, int target) {
        boolean isAsc = false;
        if (mountainArr.get(s) < mountainArr.get(e)) {
            isAsc = true;
        }
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (target == mountainArr.get(mid)) {
                return mid;
            }
            if (isAsc) {
                if (target < mountainArr.get(mid)) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else {
                if (target < mountainArr.get(mid)) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return -1;
    }
}
