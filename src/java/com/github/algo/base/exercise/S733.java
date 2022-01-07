package com.github.algo.base.exercise;

import java.util.LinkedList;
import java.util.Queue;

public class S733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int current = image[sr][sc];
        if (current == newColor) {
            return image;
        }

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        int lx = image.length;
        int ly = image[0].length;

        image[sr][sc] = newColor;
        while (queue.size() > 0) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur[0];
                int y = cur[1];
                int mx = dx[i] + x;
                int my = dy[i] + y;
                if (mx >= 0 && mx < lx && my >= 0 && my < ly && image[mx][my] == current) {
                    image[mx][my] = newColor;
                    queue.offer(new int[]{mx, my});
                }
            }
        }


        return image;
    }

}
