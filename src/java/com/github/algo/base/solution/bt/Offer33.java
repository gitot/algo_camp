package com.github.algo.base.solution.bt;

public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int left, int right) {
        if (left >= right) return true;

        int edge = left;
        while (edge < right && postorder[edge] < postorder[right]) {
            edge++;
        }

        int i = edge;
        while (i < right) {
            if (postorder[i] < postorder[right]) {
                return false;
            }
            i++;
        }

        boolean isLeftBst = verifyPostorder(postorder, left, edge - 1);
        if (!isLeftBst) return false;
        return verifyPostorder(postorder, edge, right - 1);
    }
}
