package thread;

public class SharedCounterExample {

	public static void main(String[] args) {
		SharedCounter counter = new SharedCounter();

		MyThreaeds thread1 = new MyThreaeds(counter);
		MyThread2 thread2 = new MyThread2(counter);

		thread1.start();
		thread2.start();
	}
}

class SharedCounter {
	private int counter = 0;

	// Synchronize the method to ensure atomized
	public synchronized void increment() {
		counter++;
	}

	public int getValue() {
		return counter;
	}
}

class MyThreaeds extends Thread {
	private SharedCounter counter;

	public MyThreaeds(SharedCounter counter) {
		this.counter = counter;
	}

	public void run() {
		for (int i = 5; i > 0; i--) {
			synchronized (counter) {
				counter.increment();
				System.out.println("Thread #1: Counter value = " + counter.getValue());
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread #1 is finished ");
	}
}

class MyThread2 extends Thread {
	private SharedCounter counter;

	public MyThread2(SharedCounter counter) {
		this.counter = counter;
	}

	public void run() {
		for (int i = 5; i > 0; i--) {
			synchronized (counter) {
				counter.increment();
				System.out.println("Thread #2: Counter value = " + counter.getValue());
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread #2 is finished ");
	}
}
