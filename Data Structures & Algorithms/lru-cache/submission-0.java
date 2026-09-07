class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();

    Node head;
    Node tail;

    int capacity;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Remove from current position
        remove(node);

        // Move to front because it was recently used
        insertAtFront(node);

        return node.value;
    }

    public void put(int key, int value) {

        // If key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            remove(node);
            insertAtFront(node);

            return;
        }

        // Create new node
        Node node = new Node(key, value);

        // Add to map
        map.put(key, node);

        // Add to front
        insertAtFront(node);

        // If capacity exceeded
        if (map.size() > capacity) {

            // Least recently used node
            Node lru = tail.prev;

            remove(lru);

            map.remove(lru.key);
        }
    }

    // Remove a node from the linked list
    public void remove(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert node immediately after head
    public void insertAtFront(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}