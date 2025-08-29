public class LinkedList {
    public Node head;

    // Method to create a linked list from an array
    public void createList(int[] arr) {
        if (arr.length == 0) {  // Check if the array is empty
            return;  // Return if the array is empty (no list to create)
        }
        
        head = new Node(arr[0]); // Create the head node
        Node tail = head; // Start with the head as the tail
        
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]); // Create a new node
            tail.next = newNode; // Attach the new node to the tail
            tail = newNode; // Move the tail to the new node
        }
    }

    // Method to print the linked list
    public void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.elem + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Method to get the size of the linked list
    public int get_size() {
        if (head == null) {  // If the list is empty, return 0
            return 0;
        }

        Node currentNode = head;  // Temporary variable to traverse the list
        int count = 0;

        while (currentNode != null) {  // While the current node is not null
            currentNode = currentNode.next;  // Move to the next node
            count++;  // Increment the count
        }

        return count;  // Return the total number of nodes
    }

    // Method to get the tail of the linked list
    public Node getTail() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }
    
    // Method to append a node to the linked list
    public void appendLL(int data) {
        Node newNode = new Node(data);
        if (head == null) {  // If the list is empty
            head = newNode;
            return;
        }
        Node tail = getTail();
        tail.next = newNode;
    }

    // Method to prepend a node to the linked list
    public void prependLL(int elem) {
        Node newNode = new Node(elem);
        newNode.next = head;
        head = newNode;
    }


    // Method to find the index of a specific value
    public int indexOf(int target) {
        Node current_node = head;
        int index = 0;
        while (current_node != null) {
            if (current_node.elem == target) {
                return index;
            }
            current_node = current_node.next;
            index++;
        }
        return -1;
    }
    
    // Method to check if a node with a specific value exists
    public boolean contains(int target) {
        Node current_node = head;
        while (current_node != null) {
            if (current_node.elem == target) {
                return true;
            }
            current_node = current_node.next;
        }
        return false;
    }



    // Method to get an element at a specific index
    // here the return type is int. because elem-values are int type in node class
    public int getElem(int idx) { 
        int current_index = 0;
        Node current_node = head;
        while (current_node != null) {
            if (current_index == idx) {
                return current_node.elem;
            }
            current_index++;
            current_node = current_node.next;
        }
        return -1;
    }

    // Method to get a node at a specific index
    public Node getNode(int idx) {
        int current_index = 0;
        Node current_node = head;
        while (current_node != null) {
            if (current_index == idx) {
                return current_node;
            }
            current_index++;
            current_node = current_node.next;
        }
        return null;
    }

    // Method to set a node's element at a specific index (using second approach)
    public void setNode1(int index, int newElem) {
        Node current_node = getNode(index);
        if (current_node != null) {
            current_node.elem = newElem;
            System.out.println("Successfully updated");
        } else {
            System.out.println("Invalid Index");
        }
    }
    
    // Method to set a node's element at a specific index (using first approach)
    public void setNode2(int index, int newElem) {
        Node currentNode = head;
        int current_index = 0;
        boolean isUpdated = false;

        while (currentNode != null) {
            if (current_index == index) {
                currentNode.elem = newElem;
                isUpdated = true;
                break;
            }
            currentNode = currentNode.next;
            current_index++;
        }

        if (isUpdated) {
            System.out.println("Successfully updated");
        } else {
            System.out.println("Invalid Index");
        }
    }

    // Method to insert a node at a specific index
    public void insertAt(int idx, int elem) {
        int size = get_size();

        if (idx < 0 || idx > size) { // Invalid index
            System.out.println("Insertion Failed, Not valid index");
            return;
        } else if (idx == 0) {  // Insertion at head
            Node newNode = new Node(elem);
            newNode.next = head;
            head = newNode;
        } else { // Insertion in middle or end
            Node newNode = new Node(elem);
            Node predecessor = getNode(idx - 1);
            Node successor = predecessor.next;

            newNode.next = successor;
            predecessor.next = newNode;
        }
    }

    // Method to remove a node at a specific index
    public void removeAt(int idx) {
        int size = get_size();
        if (idx < 0 || idx >= size) {
            System.out.println("Invalid Index");
            return;
        }

        // If removing the head node
        if (idx == 0) {
            head = head.next;
            return;
        }

        // Find the predecessor (node at idx-1)
        Node predecessor = getNode(idx - 1);
        Node remNode = predecessor.next;
        Node successor = remNode.next;

        // Link predecessor to successor, effectively removing remNode
        predecessor.next = successor;

        // Optional: Help garbage collector by clearing remNode's next
        remNode.next = null;
    }




    // Method to copy the linked list
    public Node copyList() {
        if (head == null) {  // If the list is empty, return null
            return null;
        }
    
        Node copy_head = new Node(head.elem);  // Create the head node of the copied list
        Node copy_tail = copy_head;            // Tail pointer for appending new nodes
    
        Node temp = head.next;  // Start from the second node of the original list
    
        while (temp != null) {  // Traverse the original list
            Node newNode = new Node(temp.elem); // Create a new node with the current element
            copy_tail.next = newNode;           // Link it to the tail of the copied list
            copy_tail = newNode;                // Move the tail pointer forward
            temp = temp.next;                   // Move to the next node in the original list
        }
    
        return copy_head;  // Return the head of the copied list
    }


    // Method to reverse the linked list out of place
    public Node reverseOutOfPlace() {
        if (head == null) {  // If the list is empty, return null
            return null;
        }

        Node revHead = new Node(head.elem);  // Create the new head for the reversed list
        Node temp = head.next;

        // Traverse the original list and add each element to the front of the reversed list
        while (temp != null) {
            Node newNode = new Node(temp.elem);  // Create a new node with the current element
            newNode.next = revHead;  // Link the new node to the front of the reversed list
            revHead = newNode;  // Update the head of the reversed list
            temp = temp.next;  // Move to the next node in the original list
        }

        return revHead;  // Return the head of the reversed list
    }

    // Method to reverse the linked list in place
    public Node reverseInPlace() {
        Node prev = null;  // Previous node starts as null
        Node current = head;  // Current node starts as the head of the list

        while (current != null) {  // Traverse until the end of the list
            Node nextNode = current.next;  // Store the next node
            current.next = prev;  // Reverse the current node's link
            prev = current;  // Move prev forward
            current = nextNode;  // Move current forward
        }

        return prev;  // New head of the reversed list
    }

    
    
    // Method to rotate the linked list left
    public void rotateLeft() {
        if (head == null || head.next == null) {  // Check for empty or single-node list
            return;
        }

        Node oldHead = head; // Keep a copy of the original head to be the new tail
        head = head.next;    // Move head to the next node (new head)

        Node tail = getNode(get_size() - 1); // Find the last node in the list
        tail.next = oldHead;    // Link the last node to the original head
        oldHead.next = null;    // Make the old head the new tail by setting next to null
    }

    
    // Method to rotate the linked list right
    public void rotateRight() {
        if (head == null || head.next == null) {  // Check for empty or single-node list
            return;
        }

        int size = get_size();
        Node newTail = getNode(size - 2); // Find the second-to-last node, which becomes the new tail
        Node oldTail = newTail.next;     // The last node, which will be the new head

        oldTail.next = head;     // Link the last node to the original head
        newTail.next = null;     // Set the new tail’s next to null
        head = oldTail;          // Update head to the old tail (new head)
    }
    
    // Method 1: rotateLeftMul using rotateLeft
    public void rotateLeftMul1(int k) {
        if (head == null || k <= 0) return;
        for (int i = 0; i < k; i++) {
            rotateLeft();
        }
    }
    
    // Method 2: rotateRightMul using rotateRight
    public void rotateRightMul1(int k) {
        if (head == null || k <= 0) return;
        for (int i = 0; i < k; i++) {
            rotateRight();
        }
    }
    
    // Method 3: rotateLeftMul2 — optimized version
    public void rotateLeftMul2(int k) {
        if (head == null || k <= 0) return;
    
        int size = get_size();
        k = k % size;
        if (k == 0) return;
    
        // Traverse to the (k-1)th node
        Node current = head;
        for (int i = 0; i < k - 1; i++) {
            current = current.next;
        }
    
        Node newHead = current.next;
        current.next = null;
    
        Node tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }
    
        tail.next = head;
        head = newHead;
    }
    
    // Method 4: rotateRightMul2 — using left rotation
    public void rotateRightMul2(int k) {
        if (head == null || k <= 0) return;
    
        int size = get_size();
        k = k % size;
        if (k == 0) return;
    
        rotateLeftMul2(size - k);
    }
    
    

}
