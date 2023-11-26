package thread;

public class Threadings {

    class A extends Thread {
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello");
            }
        }
    }

    class B extends Thread {
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hi");
            }
        }
    }

    public static void main(String[] args) {
        Threadings threadings = new Threadings(); // create an instance of the outer class
        A a = threadings.new A(); // create an instance of class A
        B b = threadings.new B(); // create an instance of class B
        try {
			a.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        a.start(); // start the thread for class A
        b.start(); // start the thread for class B
    }
}
