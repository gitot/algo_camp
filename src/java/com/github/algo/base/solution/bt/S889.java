package com.github.algo.base.solution.bt;

public class S889 {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructFromPrePost(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode constructFromPrePost(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) return root; // why doing this? todo

        int rootPosition = postStart;
        while (postorder[rootPosition] != preorder[preStart + 1]) {
            rootPosition++;
        }
        int leftTreeSize = rootPosition - postStart + 1;

        root.left = constructFromPrePost(preorder, preStart + 1, preStart + leftTreeSize, postorder, postStart, rootPosition);
        root.right = constructFromPrePost(preorder, preStart + leftTreeSize + 1, preEnd, postorder, rootPosition + 1, postEnd - 1);
        return root;
    }
}
