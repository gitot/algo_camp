package com.github.algo.base.solution.bt.heap;

public class S208 {
    class Trie {

        Node root = new Node('/');

        public Trie() {

        }

        public void insert(String word) {
            char[] charArray = word.toCharArray();
            Node p = root;
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                if (p.children[c - 'a'] == null) {
                    p.children[c - 'a'] = new Node(c);
                }
                p = p.children[c - 'a'];
            }
            p.isEnding = true;
        }

        public boolean search(String word) {
            char[] charArray = word.toCharArray();
            Node p = root;
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                if (p.children[c - 'a'] == null) {
                    return false;
                }
                p = p.children[c - 'a'];
            }
            return p.isEnding;
        }

        public boolean startsWith(String prefix) {
            char[] charArray = prefix.toCharArray();
            Node p = root;
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                if (p.children[c - 'a'] == null) {
                    return false;
                }
                p = p.children[c - 'a'];
            }
            return true;
        }

        class Node {
            char data;
            boolean isEnding;
            Node[] children = new Node[26];

            public Node(char data) {
                this.data = data;
            }
        }
    }



}
