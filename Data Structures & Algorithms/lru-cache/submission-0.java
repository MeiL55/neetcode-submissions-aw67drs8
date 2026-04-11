public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {
    private int cap;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        cap = capacity;
        cache = new HashMap<>();
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    private void insert(Node node) {
        Node prev = right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            int val = node.val;
            remove(node);
            insert(node);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);
        if (cache.size() > cap) {
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
