public class QueueDHCLLTest {
    public static void main(String[] args) {
        QueueDHCLL queue = new QueueDHCLL();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        
        System.out.println("Original Queue:");
        queue.displayQueue();
        
        System.out.println("Size of queue: " + queue.size());
        System.out.println("Peek at front element: " + queue.peek());
        System.out.println("Search for 20 in the queue: " + queue.search(20));
        System.out.println("Search for 40 in the queue: " + queue.search(40));
        System.out.println("Search for 60 in the queue: " + queue.search(60));
        System.out.println("Queue as string: " + queue.toString());
        
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
        
        System.out.println("Queue after dequeue:");
        queue.displayQueue();
        
        System.out.println("Size of queue after dequeue: " + queue.size());
        
        System.out.println("\nEmptying the queue...");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued element: " + queue.dequeue());
        }
        
        
        System.out.println("Trying to peek() from empty LL");
        try {
            System.out.println("Peek at front element: " + queue.peek());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Trying to dequeue() from empty LL");
        try {
            System.out.println("Dequeued element: " + queue.dequeue());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}