package thread;

class PriorityThread extends Thread {
    public PriorityThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println("Thread " + getName() + " is running.");
    }
}