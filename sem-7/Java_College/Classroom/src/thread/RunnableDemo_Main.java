package thread;

public class RunnableDemo_Main {

	public static void main(String[] args) {
		
		RunnableDemo r1 = new RunnableDemo("one");	// create objects and set name
		Thread t1 = new Thread(r1);	// Thread used
		t1.start();	// start the thread
		
		RunnableDemo r2 = new RunnableDemo("Second");	// create objects and set name
		Thread t2 = new Thread(r2);
		t2.start();
		
		
	}

}
