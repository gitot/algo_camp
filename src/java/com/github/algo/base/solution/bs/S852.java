package com.github.algo.base.solution.bs;

public class S852 {
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0) {
                left = mid + 1;
            } else if (mid == len - 1) {
                right = mid - 1;
            } else if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid - 1] < arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
