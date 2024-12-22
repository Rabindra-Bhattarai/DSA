// Define the main class for the doubly linked list
public class doublyLinkedList {
    // Define the nested static class Node to represent a single node in the doubly
    // linked list
    public static class Node {
        Node prev; // Reference to the previous node in the list
        Node next; // Reference to the next node in the list
        int data; // Data value stored in the node

        // Constructor to initialize the node with a data value
        Node(int data) {
            this.data = data; // Assign the provided value to the node's data field
            this.next = this.prev = null; // Initialize next and prev references to null
        }
    }

    Node head = null; // Initialize the head of the list to null
    Node tail = null; // Initialize the tail of the list to null

    // Method to insert a new node with the given data into the doubly linked list
    void insert(int data) {
        Node newnode = new Node(data); // Create a new node with the provided data
        if (head == null) { // Check if the list is empty
            head = tail = newnode; // If empty, set both head and tail to the new node
        } else { // If the list is not empty
            tail.next = newnode; // Link the current tail's next reference to the new node
            newnode.prev = tail; // Link the new node's previous reference to the current tai/ ,.?//l
            tail = newnode; // Update the tail to point to the new node
        }
    }

    // Method to print all the elements in the doubly linked list
    void printList() {
        Node current = head; // Start from the head of the list
        while (current != null) { // Iterate through the list until the end
            System.out.println(current.data); // Print the data of the current node
            current = current.next; // Move to the next node in the list
        }
    }
}
