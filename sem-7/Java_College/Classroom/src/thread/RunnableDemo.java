package thread;

public class RunnableDemo implements Runnable {

	String name; // declare global variable

	RunnableDemo(String n) { // set the name
		name = n;
		System.out.println("Creating : " + name); // display name
	}

	public void run() { // create new class
		System.out.println("Running : " + name); // Display
		
		// use try and catch methods
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("Thread: " + name + " Printing : " + i);
				Thread.sleep(50); // put thread in sleep
			}
		} catch (InterruptedException ex) { // catch statement
			System.out.println("Thread" + name + "interrupted");
		}
		System.out.println("Thread: " + name + " exiting");
	}

}
