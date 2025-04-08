class CustomHashMap {

    // Linked list node for separate chaining
    static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1000; // Size of the underlying array
    private Node[] buckets;

    public CustomHashMap() {
        buckets = new Node[SIZE];
    }

    // Hash function
    private int getIndex(int key) {
        return Integer.hashCode(key) % SIZE;
    }

    // Put key-value pair
    public void put(int key, int value) {
        int index = getIndex(key);
        Node head = buckets[index];

        // Check if key exists, update value
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        // Insert new node at head
        Node newNode = new Node(key, value);
        newNode.next = head;
        buckets[index] = newNode;
    }

    // Get value by key
    public int get(int key) {
        int index = getIndex(key);
        Node current = buckets[index];

        while (current != null) {
            if (current.key == key) return current.value;
            current = current.next;
        }

        return -1; // Key not found
    }

    // Remove key-value pair
    public void remove(int key) {
        int index = getIndex(key);
        Node current = buckets[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }

            prev = current;
            current = current.next;
        }
    }

    // Optional: Print hashmap contents
    public void printMap() {
        for (int i = 0; i < SIZE; i++) {
            Node node = buckets[i];
            if (node != null) {
                System.out.print("Bucket " + i + ": ");
                while (node != null) {
                    System.out.print("(" + node.key + ", " + node.value + ") ");
                    node = node.next;
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 10);
        map.put(2, 20);
        map.put(1001, 30); // Collides with key 1 if SIZE is 1000

        System.out.println("Value for key 1: " + map.get(1)); // 10
        System.out.println("Value for key 2: " + map.get(2)); // 20
        System.out.println("Value for key 1001: " + map.get(1001)); // 30

        map.remove(1);
        System.out.println("Value for key 1 after removal: " + map.get(1)); // -1

        // map.printMap(); // Uncomment to see all stored elements
    }
}
