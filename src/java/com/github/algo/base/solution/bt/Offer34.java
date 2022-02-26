package com.github.algo.base.solution.bt;

import java.util.ArrayList;
import java.util.List;

public class Offer34 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) return res;
        pathSum(root, target, new ArrayList<>(), 0);
        return res;
    }

    private void pathSum(TreeNode root, int target, List<Integer> path, int pathSum) {
        pathSum += root.val;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (pathSum == target) {
                List<Integer> snapshot = new ArrayList<>();
                snapshot.addAll(path);
                res.add(snapshot);
            }
            path.remove(path.size() - 1);
            return;
        }

        if (root.left != null) {
            pathSum(root.left, target, path, pathSum);
        }
        if (root.right != null) {
            pathSum(root.right, target, path, pathSum);
        }
        path.remove(path.size() - 1);
    }
}
