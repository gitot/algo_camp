package com.github.algo.base.solution.base;

public class S26 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) return len;

        int k = 0;
        for (int j = 1; j < len; j++) {
            if (nums[j] != nums[k]) {
                k++;
                nums[k] = nums[j];
            }
        }
        return k + 1;
    }

    public static void main(String[] args) {
        S26 s = new S26();
        System.out.println(s.removeDuplicates(new int[0]));
        System.out.println(s.removeDuplicates(new int[]{1}));
        System.out.println(s.removeDuplicates(new int[]{1, 1}));
        System.out.println(s.removeDuplicates(new int[]{1, 1, 1}));
        System.out.println(s.removeDuplicates(new int[]{1, 2, 3}));
        System.out.println(s.removeDuplicates(new int[]{1, 2, 3, 3}));
        System.out.println(s.removeDuplicates(new int[]{1, 2, 3, 3, 3}));
        System.out.println(s.removeDuplicates(new int[]{1, 2, 2, 3, 3, 3}));
    }
}
