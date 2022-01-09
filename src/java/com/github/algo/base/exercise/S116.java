package com.github.algo.base.exercise;

//Why cannot use one node as parameter?
public class S116 {
    public Node connect(Node root) {
        if (root == null) return null;
        connectNode(root.left, root.right);
        return root;
    }

    private void connectNode(Node left, Node right) {
        if (left == null || right == null) return;

        left.next = right;

        connectNode(left.left, left.right);
        connectNode(right.left, right.right);
        connectNode(left.right, right.left);
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

}
