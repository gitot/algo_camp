package com.github.algo.base.intro;

/**
 * 二分解法，来回折腾了好几次才写对。
 * 都是一些低级错误导致的，如： 数组下标和取值混淆，下标初始值错误等。
 */
public class S704 {
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) return i;
        }
        return -1;
    }


    public int binarySearch(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == target) return i;
            if (nums[j] == target) return j;
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }

}
