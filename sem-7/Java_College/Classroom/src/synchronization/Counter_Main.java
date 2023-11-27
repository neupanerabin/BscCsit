package synchronization;

public class Counter_Main {

	public static void main(String[] args) {

		Counter count = new Counter();

		for (int i = 0; i < 1000; i++) {
			System.out.println(count.j);
			count.increment();

		}

		Counter count1 = new Counter();
		System.out.println("new :" + count1.j);

		System.out.println(Thread.activeCount());

	}

}
