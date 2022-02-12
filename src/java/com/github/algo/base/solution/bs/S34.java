package com.github.algo.base.solution.bs;

public class S34 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] res = new int[]{-1, -1};
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0 && nums[mid] == target) {
                res[0] = mid;
                break;
            } else if (nums[mid] == target && nums[mid - 1] < target) {
                res[0] = mid;
                break;
            } else if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        left = 0;
        right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == len - 1 && nums[mid] == target) {
                res[1] = mid;
                break;
            } else if (nums[mid] == target && nums[mid + 1] > target) {
                res[1] = mid;
                break;
            } else if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }


}
