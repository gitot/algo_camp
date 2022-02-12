package com.github.algo.base.solution.bs;

public class S374 extends GuessGame{
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int guess = guess(mid);
            if (guess == 0) {
                return mid;
            } else if (guess < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //never expect this
        return 0;
    }
}
