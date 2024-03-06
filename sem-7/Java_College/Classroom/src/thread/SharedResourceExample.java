package thread;

public class SharedResourceExample {
    private static final int MAX_COUNT = 5;
    private static int counter = 0;

    public static void main(String[] args) {
        // Create two threads
        Thread thread1 = new Thread(new IncrementTask());
        Thread thread2 = new Thread(new IncrementTask());

        // Start the threads
        thread1.start();
        thread2.start();

        try {
            // Wait for both threads to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final counter value: " + counter);
    }

    static class IncrementTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < MAX_COUNT; i++) {
                synchronized (SharedResourceExample.class) {
                    // Increment the counter
                    counter++;
                    System.out.println(Thread.currentThread().getName() + ": Counter = " + counter);
                }
            }
        }
    }
}
