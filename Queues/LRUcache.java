import java.util.*;

public class LRUcache {
    static class lru {
        static int capacity;

        static class Node {
            int key;
            int val;
            Node next;
            Node prev;

            Node(int k, int v) {
                key = k;
                val = v;
            }
        }

        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);
        HashMap<Integer, Node> map = new HashMap<>();

        public lru(int cap) {
            cap = capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node get = map.get(key);
            deleteBeforeTail(get);
            insertAfterHead(get);
            return get.val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node get = map.get(key);
                get.val = value;
                deleteBeforeTail(get);
                insertAfterHead(get);
            } else {
                if (map.size() == capacity) {
                    deleteBeforeTail(tail.prev);
                    map.remove(key);
                } else {
                    Node newNode = new Node(key, value);
                    insertAfterHead(newNode);
                    map.put(key, newNode);
                }
            }
        }

        public void insertAfterHead(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        public void deleteBeforeTail(Node node) {
            Node before = node.prev;
            Node after = node.next;
            before.next = after;
            after.prev = before;
        }
    }
}
