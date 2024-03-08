package thread;

public class ThreadPriorityExample {
    public static void main(String[] args) {
        PriorityThread thread1 = new PriorityThread("Thread 1");
        PriorityThread thread2 = new PriorityThread("Thread 2");
        PriorityThread thread3 = new PriorityThread("Thread 3");

        // Set thread priorities
        thread1.setPriority(Thread.MIN_PRIORITY); // Lowest priority (1)
        thread2.setPriority(Thread.NORM_PRIORITY); // Default priority (5)
        thread3.setPriority(Thread.MAX_PRIORITY); // Highest priority (10)

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for all threads to finish
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread exiting.");
    }
}