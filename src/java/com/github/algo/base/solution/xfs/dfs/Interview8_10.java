package com.github.algo.base.solution.xfs.dfs;

public class Interview8_10 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        image[sr][sc] = newColor;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < directions.length; i++) {
            int x = directions[i][0] + sr;
            int y = directions[i][1] + sc;
            if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && image[x][y] == oldColor) {
                dfs(image, x, y, newColor, oldColor);
            }
        }
    }
}