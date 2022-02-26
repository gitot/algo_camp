package com.github.algo.base.solution.bt;

public class S105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) return null;

        int rootVal = preorder[preStart];

        int rootPosition = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootPosition = i;
                break;
            }
        }
        int leftTreeSize = rootPosition - inStart;

        TreeNode left = buildTree(preorder, preStart + 1, preStart + leftTreeSize, inorder, inStart, rootPosition - 1);
        TreeNode right = buildTree(preorder, preStart + leftTreeSize + 1, preEnd, inorder, rootPosition + 1, inEnd);
        TreeNode root = new TreeNode(rootVal);
        root.left = left;
        root.right = right;
        return root;
    }
}
