package com.github.algo.base.solution.sort;

public class SOffer51 {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        int[] tmp = new int[len];
        int count = reversePairs(nums, 0, len - 1, tmp);
        return count;
    }

    private int reversePairs(int[] nums, int left, int right, int[] tmp) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;

        int leftPairs = reversePairs(nums, left, mid, tmp);
        int rightPairs = reversePairs(nums, mid + 1, right, tmp);

        //there is no element on left side that can contribute to the final result,
        //so just add reversePairs on both sides.
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        //calculate the contribution between both sides
        int count = mergeAndCount(nums, left, mid, right, tmp);
        return count + leftPairs + rightPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] tmp) {
        System.arraycopy(nums, left, tmp, left, right - left + 1);


        int lp = left;
        int rp = mid + 1;

        int count = 0;
        for (int i = left; i <= right; i++) {
            if (lp >= mid + 1) {
                nums[i] = tmp[rp++];
            } else if (rp >= right + 1) {
                nums[i] = tmp[lp++];
            } else if (tmp[lp] <= tmp[rp]) {
                nums[i] = tmp[lp++];
            } else {
                nums[i] = tmp[rp++];
                count += (mid - lp + 1);
            }
        }

        return count;
    }

}
