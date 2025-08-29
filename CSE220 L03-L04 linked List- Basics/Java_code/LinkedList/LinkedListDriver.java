public class LinkedListDriver {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Creating a linked list from an array
        int[] elements = {1, 2, 3, 4, 5};
        list.createList(elements);
        System.out.println("Original Linked List:");
        list.printLL(list.head);

        // Appending an element
        list.appendLL(6);
        System.out.println("After appending 6:");
        list.printLL(list.head);

        // Prepending an element
        list.prependLL(0);
        System.out.println("After prepending 0:");
        list.printLL(list.head);

        // Getting the size of the linked list
        System.out.println("Size of the linked list: " + list.get_size());

        // Checking if a value exists in the list
        System.out.println("Contains 3? " + list.contains(3));
        System.out.println("Contains 10? " + list.contains(10));

        // Getting an element at a specific index
        System.out.println("Element at index 3: " + list.getElem(3));

        // Finding the index of a specific value
        System.out.println("Index of element 4: " + list.indexOf(4));

        // Setting a node value
        list.setNode1(2, 10);
        System.out.println("After updating index 2 to 10:");
        list.printLL(list.head);

        // Inserting at a specific index
        list.insertAt(3, 99);
        System.out.println("After inserting 99 at index 3:");
        list.printLL(list.head);

        // Removing a node at a specific index
        list.removeAt(4);
        System.out.println("After removing element at index 4:");
        list.printLL(list.head);

        // Copying the linked list
        Node copiedListHead = list.copyList();
        System.out.println("Copied linked list:");
        printLL(copiedListHead);  

        // Reversing the list out of place
        Node reversedList = list.reverseOutOfPlace();
        System.out.println("Reversed (out of place) linked list:");
        printLL(reversedList);  

        // Reversing the list in place
        list.head = list.reverseInPlace();
        System.out.println("Reversed (in place) linked list:");
        list.printLL(list.head);
        
        // ========= Basic Left & Right Rotation =========
        System.out.println("======== Basic Single Left Rotation by 1========");
        list.createList(new int[]{10, 20, 30, 40, 50});
        list.rotateLeft();
        System.out.println("After rotating left:");
        list.printLL(list.head);
    
        // ========= Basic Single Right Rotation =========
        System.out.println("======== Basic Single Right Rotation by 1 ========");
        list.rotateRight();
        System.out.println("After rotating right:");
        list.printLL(list.head);
 
        // ========= rotateLeftMul1 (Loop-based Left Rotation) =========
        System.out.println("======== Testing rotateLeftMul1 (k=2) ========");
        list.createList(new int[]{10, 20, 30, 40, 50});
        list.rotateLeftMul1(2);
        list.printLL(list.head);
        
        System.out.println("======== Testing rotateLeftMul1 again (k=1) ========");
        list.rotateLeftMul1(1);
        list.printLL(list.head);
        
        // ========= rotateRightMul1 (Loop-based Right Rotation) =========
        System.out.println("======== Testing rotateRightMul1 (k=2) ========");
        list.createList(new int[]{10, 20, 30, 40, 50});
        list.rotateRightMul1(2);
        list.printLL(list.head);
        
        System.out.println("======== Testing rotateRightMul1 again (k=1) ========");
        list.rotateRightMul1(1);
        list.printLL(list.head);
        
        
        // ========= rotateLeftMul2 (Optimized Left Rotation) =========
        System.out.println("======== Testing rotateLeftMul2 (optimized, k=2) ========");
        list.createList(new int[]{10, 20, 30, 40, 50});
        list.rotateLeftMul2(2);
        list.printLL(list.head);
        
        System.out.println("======== Testing rotateLeftMul2 again (k=1) ========");
        list.rotateLeftMul2(1);
        list.printLL(list.head);
        
        
        // ========= rotateRightMul2 (Optimized Right Rotation) =========
        System.out.println("======== Testing rotateRightMul2 (optimized, k=2) ========");
        list.createList(new int[]{10, 20, 30, 40, 50});
        list.rotateRightMul2(2);
        list.printLL(list.head);
        
        System.out.println("======== Testing rotateRightMul2 again (k=1) ========");
        list.rotateRightMul2(1);
        list.printLL(list.head);

    }

    //  Helper method to print lists that are not inside the main list object
    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.elem + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
