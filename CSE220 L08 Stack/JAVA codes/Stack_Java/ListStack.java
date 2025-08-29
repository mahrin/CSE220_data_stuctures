class ListStack {
    private Node top; // Represents the top of the stack (head node)
    private int size; // Tracks the size of the stack

    // Constructor
    public ListStack() {
        this.top = null; // Initially, the stack is empty
        this.size = 0;
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Pushes an element onto the stack
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top; // Link the new node to the current top
        top = newNode;      // Update top to the new node
        size++;
    }

    // Pops the top element from the stack
    public int pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Underflow: Pop from empty stack");
        }
        int poppedData = top.data; // Retrieve data of the top node
        top = top.next;            // Update top to the next node
        size--;
        return poppedData;
    }

    // Peeks at the top element of the stack
    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Underflow: Peek from empty stack");
        }
        return top.data;
    }

    // Returns the size of the stack
    public int getSize() {
        return size;
    }

    // Converts the stack to an array representation (from top to bottom)
    public int[] toArray() {
        int[] elements = new int[size];
        Node current = top;
        int index = 0;
        while (current != null) {
            elements[index++] = current.data; // Collect data from top to bottom
            current = current.next;
        }
        return elements;
    }

    public static void main(String[] args) {
        ListStack stack = new ListStack();

        // Pushing elements
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println("Stack (top -> bottom): " + java.util.Arrays.toString(stack.toArray())); // [40, 30, 20, 10]
        System.out.println("Size: " + stack.getSize()); // Size: 4

        // Peeking
        System.out.println("Peek: " + stack.peek()); // Peek: 40

        // Popping elements
        System.out.println("Popped: " + stack.pop()); // Popped: 40
        System.out.println("Stack (top -> bottom): " + java.util.Arrays.toString(stack.toArray())); // [30, 20, 10]
        System.out.println("Size: " + stack.getSize()); // Size: 3
        System.out.println("Is empty: " + stack.isEmpty()); // Is empty: False

        // Clearing stack
        while (!stack.isEmpty()) {
            System.out.println("Popped element from top: " + stack.pop());
        }

        System.out.println("Is empty: " + stack.isEmpty()); // Is empty: True
        System.out.println("Size: " + stack.getSize());     // Size: 0

        // Uncomment to see errors for operations on empty stack
        // System.out.println("Peek: " + stack.peek()); // Error: empty stack
        // System.out.println("Popped: " + stack.pop()); // Error: empty stack
    }
}
