package com.github.algo.base.solution.bt;

/**
 * The reason why I failed to solve the problem several times at the beginning
 * is my impatience to understand it --- I didn't see the requirement
 * that a circus double linked list should be returned, not double linked list only.
 */
public class SOffer36 {

    Node sentinel = new Node();
    Node tail = sentinel;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        preOrder(root);

        Node head = sentinel.right;
        head.left = tail;
        tail.right = head;

        return head;
    }

    private void preOrder(Node root) {
        if (root == null) return;

        Node right = root.right;

        preOrder(root.left);

        tail.right = root;
        root.left = tail;
        tail = tail.right;

        preOrder(right);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Node node = buildTree();
        SOffer36 s = new SOffer36();
        s.treeToDoublyList(node);
    }

    private static Node buildTree() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node2.left = node1;
        node2.right = node3;
        node4.left = node2;
        node4.right = node5;
        return node4;
    }
}
