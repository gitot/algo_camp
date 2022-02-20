package com.github.algo.base.solution.hashtable;

import java.util.HashMap;
import java.util.Map;

public class S146 {
    // TODO: 2/20/2022 Not accepted
    class LRUCache {

        int capacity;
        Map<Integer, Node> map;
        Node head;
        Node tail;
        int size;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            touchNode(node);
            return node.value;
        }

        //move node to the head of the linkList
        private void touchNode(Node node) {
            removeNode(node);
            addAtHead(node);
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                map.remove(key);
                removeNode(node);
                node.value = value;
                map.put(key, node);
                addAtHead(node);
                return;
            }
            if (size >= capacity) {
                removeNode(tail.prev);
                map.remove(tail.prev.key);
                size--;
            }
            Node newNode = new Node(key,value);
            map.put(key, newNode);
            addAtHead(newNode);
            size++;
        }

        private void addAtHead(Node newNode) {
            newNode.next = head.next;
            head.next.prev = newNode;
            newNode.prev = head;
            head.next = newNode;
        }

        private void removeNode(Node node) {
            //remove node from the linkList
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        class Node {
            int key;
            int value;
            Node prev;
            Node next;

            public Node(int key,int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
