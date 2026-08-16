class Node {
    private int key;
    private int value;
    private Node next;
    private Node prev;

    public Node (int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
    }

}


class LRUCache {
    private int capacity;
    private Node left;
    private Node right;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.map = new HashMap();
        this.capacity = capacity;
        this.left = new Node(0, 0);
        this.right = new Node(0,0);
        this.left.next = right;
        this.right.prev = left;
    }
    
    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void insert(Node node) {
        Node prev = right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            remove(curr);
            insert(curr);
            return curr.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            remove(temp);
            temp.value = value;
            insert(temp);
        } else {
            if (map.size() >= capacity) {
                Node least = left.next;
                remove (least);
                map.remove(least.key);
            }
            Node curr = new Node(key, value);
            insert(curr);
            map.put(curr.key, curr);
        }
    }
}
