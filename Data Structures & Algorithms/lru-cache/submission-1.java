class Node {
    private int key;
    private int val;
    private Node next;
    private Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }

}


class LRUCache {
    private int capacity;
    private Map<Integer, Node> map;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        left.next = right;
        right.prev = left;
    }
    
    public void insert(Node node) {
        Node prev = right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    }

    public void delete(Node node) {
        Node prev = node.prev;
        Node next = node. next;
        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node currentNode = map.get(key);
            delete(currentNode);
            insert(currentNode);
            return currentNode.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node currentNode = map.get(key);
            currentNode.val = value;
            delete(currentNode);
            insert(currentNode);
        } else {
            if (map.size() >= capacity) {
                Node least = left.next;
                delete(least);
                map.remove(least.key);
            }
            Node update = new Node(key, value);
            insert(update);
            map.put(key, update);
        }
    }
}
