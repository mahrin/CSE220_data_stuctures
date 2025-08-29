public class QueueTest_Singly_LL {
    public static void main(String[] args) {
        Queue_nonDHSLL queue = new Queue_nonDHSLL();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println("Original Queue:");
        queue.displayQueue(); // Queue (front to rear): 10 -> 20 -> 30 -> 40 -> NULL

        System.out.println("Size of queue: " + queue.size());
        System.out.println("Peek at front element: " + queue.peek());
        System.out.println("Search for 20 in the queue: " + queue.search(20));
        System.out.println("Search for 40 in the queue: " + queue.search(40));
        System.out.println("Search for 60 in the queue: " + queue.search(60));

        System.out.println("Queue as string: " + queue.toString());
        System.out.print("Queue as array: ");
        for (int num : queue.toArray()) {
            System.out.print(num + " ");
        }
        System.out.println();

        queue.dequeue(); // Removes 10
        queue.dequeue(); // Removes 20
        System.out.println("Queue after dequeue:");
        queue.displayQueue(); // Expected Output: Queue (front to rear): 30 -> 40 -> NULL

        System.out.println("Size of queue after dequeue: " + queue.size());

        System.out.println("\nEmptying the queue...");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued element: " + queue.dequeue());
        }

        // Try to peek when empty
        System.out.println("\nEmptying the queue...");
        try {
            System.out.println("Peek at front element: " + queue.peek());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Try to dequeue when empty
        System.out.println("Trying to peek() from empty LL");
        try {
            System.out.println("Dequeued element: " + queue.dequeue());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
