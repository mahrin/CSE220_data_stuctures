class Node {
    int elem;
    Node next;

    Node(int elem) {
        this.elem = elem;
        this.next = null;
    }
}

public class RecursionExamples03LinkedList {

    // Example 11: Convert array to linked list (iterative)
    public static Node arr2LL_iterative(int[] arr) {
        Node head = new Node(arr[0]);
        Node current = head;
        int i = 1;
        while (i < arr.length) {
            Node newNode = new Node(arr[i]);
            current.next = newNode;
            current = current.next;
            i++;
        }
        return head;
    }

    // Convert array to linked list (recursive)
    public static Node arr2LL_recursive(int[] arr, int index) {
        if (index == arr.length) {
            return null;
        }
        Node current = new Node(arr[index]);
        current.next = arr2LL_recursive(arr, index + 1);
        return current;
    }

    // Print linked list iteratively
    public static void printLL_iterative(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.elem + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Example 12: Print linked list forward using recursion
    public static void printForward_recursive(Node temp) {
        if (temp == null) {
            System.out.println("null");
            return;
        } else {
            System.out.print(temp.elem + " => ");
            printForward_recursive(temp.next);
        }
    }

    // Example 13: Print linked list backward using recursion
    public static void printBackward_recursive(Node temp) {
        if (temp == null) {
            return;
        } else {
            printBackward_recursive(temp.next);
            System.out.print(temp.elem + " <= ");
        }
    }

    // Example 14: Find maximum value iteratively
    public static Integer find_max_iterative(Node head) {
        if (head == null) {
            return null;
        }
        int max_value = head.elem;
        Node current = head.next;
        while (current != null) {
            if (current.elem > max_value) {
                max_value = current.elem;
            }
            current = current.next;
        }
        return max_value;
    }

    public static int find_max_recursive(Node temp) {
        // Base case: if there's only one node, return its value
        if (temp.next == null) {
            return temp.elem;
        }

        // Recursive case: find the maximum in the rest of the list
        int max_val = temp.elem; // value of the head/temp
        int max_node_rest_val = find_max_recursive(temp.next);

        // Compare the current node's value (temp.elem) with the maximum value of the rest
        if (max_node_rest_val > max_val) {
            max_val = max_node_rest_val;
        }
        return max_val;
    }

    // Example 15: Find minimum value iteratively
    public static Integer find_min_iterative(Node head) {
        if (head == null) {
            return null;
        }
        int min_value = head.elem;
        Node current = head.next;
        while (current != null) {
            if (current.elem < min_value) {
                min_value = current.elem;
            }
            current = current.next;
        }
        return min_value;
    }

    public static int find_min_recursive(Node temp) {
        // Base case: if there's only one node, return its value
        if (temp.next == null) {
            return temp.elem;
        }

        // Recursive case: find the minimum in the rest of the list
        int min_val = temp.elem;
        int min_node_rest_val = find_min_recursive(temp.next);

        // Compare the current node's value (temp.elem) with the minimum value of the rest
        if (min_node_rest_val < min_val) {
            min_val = min_node_rest_val;
        }

        return min_val;
    }

    public static void main(String[] args) {
        // Example 11
        System.out.println("Example 11: Array to Linked List (iterative)");
        Node head = arr2LL_iterative(new int[]{10, 20, 30, 40, 50});
        printLL_iterative(head);

        System.out.println("Example 11: Array to Linked List (recursive)");
        Node headRec = arr2LL_recursive(new int[]{10, 20, 30, 40, 50}, 0);
        printLL_iterative(headRec);

        // Example 12
        System.out.println("Example 12: Print Forward (recursive)");
        printForward_recursive(headRec);

        // Example 13
        System.out.println("Example 13: Print Backward (recursive)");
        printBackward_recursive(headRec);
        System.out.println("null");

        // Example 14: Find max
        System.out.println("Example 14: Find Max (iterative)");
        Node headMax = arr2LL_iterative(new int[]{10, 20, 5, 15});
        printLL_iterative(headMax);
        int max = find_max_iterative(headMax);
        System.out.println("Maximum value: " + max);

        System.out.println("Example 14: Find Max (recursive)");
        Node headMaxRec = arr2LL_iterative(new int[]{10, 20, 5, 25, 3});
        printLL_iterative(headMaxRec);
        int maxRec = find_max_recursive(headMaxRec);
        System.out.println("Maximum value: " + maxRec);

        // Example 15: Find min
        System.out.println("Example 15: Find Min (iterative)");
        Node headMin = arr2LL_iterative(new int[]{10, 20, 5, 15});
        printLL_iterative(headMin);
        int min = find_min_iterative(headMin);
        System.out.println("Minimum value: " + min);

        System.out.println("Example 15: Find Min (recursive)");
        Node headMinRec = arr2LL_iterative(new int[]{10, 20, 5, 15});
        printLL_iterative(headMinRec);
        int minRec = find_min_recursive(headMinRec);
        System.out.println("Minimum value: " + minRec);
    }
}