package com.github.algo.base.solution.bt;

public class S106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
        if (inStart > inEnd) return null;

        int rootPosition = inStart;
        while (inorder[rootPosition] != postOrder[postEnd]) {
            rootPosition++;
        }
        int leftTreeSize = rootPosition - inStart;

        TreeNode root = new TreeNode(postOrder[postEnd]);
        root.left = buildTree(inorder, inStart, rootPosition - 1, postOrder, postStart, postStart + leftTreeSize - 1);
        root.right = buildTree(inorder, rootPosition + 1, inEnd, postOrder, postStart + leftTreeSize, postEnd - 1);
        return root;
    }
}
