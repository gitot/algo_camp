package com.github.algo.base.solution.sort;

public class S56 {
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (length <= 1) {
            return intervals;
        }


        //sort intervals based on first num in each element
        for (int i = 0; i < length; i++) {
            int edge = length - i - 1;
            for (int j = 0; j < edge; j++) {
                if (intervals[j][0] > intervals[j + 1][0]) {
                    int[] tmp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = tmp;
                }
            }
        }


        int right = 1;
        int left = 0;
        while (right < length) {
            if (intervals[left][1] >= intervals[right][0]) {
                //merge to array
                int newRight = intervals[right][1] > intervals[left][1] ? intervals[right][1] : intervals[left][1];
                intervals[left] = new int[]{intervals[left][0], newRight};
            } else {
                intervals[left + 1] = intervals[right];
                left++;
            }
            right++;
        }

        int[][] res = new int[left + 1][2];
        for (int i = 0; i <= left; i++) {
            res[i] = intervals[i];
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "[[1,3],[2,6],[8,10],[15,18]]";
        int[][] array = new int[4][2];
        array[0] = new int[]{1, 3};
        array[1] = new int[]{2,6};
        array[2] = new int[]{8,10};
        array[3] = new int[]{15,18};

        int[][] merge = new S56().merge(array);
        System.out.println();
    }
}
