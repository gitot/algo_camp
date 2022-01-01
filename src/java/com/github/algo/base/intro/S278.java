package com.github.algo.base.intro;

public class S278 extends VersionControl {
    public int firstBadVersion(int n) {
        int i = 1, j = n;
        while (i <= j) {
            if (isFirstBadVersion(i)) {
                return i;
            }
            if (isFirstBadVersion(j)) {
                return j;
            }

            int mid = (i + j) / 2;
            if (isFirstBadVersion(mid)) {
                return mid;
            } else if (isBadVersion(mid)) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return Integer.MAX_VALUE;
    }

    private boolean isFirstBadVersion(int i) {
        if (i == 1) {
            return isBadVersion(i);
        }
        if (!isBadVersion(i - 1) && isBadVersion(i)) {
            return true;
        }
        return false;
    }
}
