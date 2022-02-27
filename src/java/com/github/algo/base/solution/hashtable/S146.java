package com.github.algo.base.solution.hashtable;

import java.util.HashMap;
import java.util.Map;

public class S146 {
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
            head.prev = null;
            tail.prev = head;
            tail.next = null;
        }

        public int get(int key) {
            if (size <= 0) return -1;
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
                node.value = value;
                removeNode(node);
                addAtHead(node);
                return;
            }
            if (size >= capacity) {
                map.remove(tail.prev.key); //this must be before the next statement !!
                removeNode(tail.prev);
                size--;
            }
            Node newNode = new Node(key,value);
            map.put(key, newNode);
            addAtHead(newNode);
            size++;
        }

        private void addAtHead(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
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


    public static void main(String[] args) {
        S146 s146 = new S146();
        S146.LRUCache cache = s146.new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        int i = cache.get(1);
        cache.put(3, 3);
        int i1 = cache.get(2);
        cache.put(4, 4);
        int i2 = cache.get(1);
        int i3 = cache.get(3);
        int i4 = cache.get(4);


    }
}
