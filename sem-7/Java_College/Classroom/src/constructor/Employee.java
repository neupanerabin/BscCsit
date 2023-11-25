package constructor;

public class Employee {
	
	int eid;
	int salary;
	static String ceo;
	
	public Employee() {
		 eid=1;
		 salary= 100;
		System.out.println("\n Construcor: "+ ceo);

	}
	
	
	static {
		ceo = "Ram";
		System.out.println("Ststic "+ ceo);
	}
	
	void show() {
		System.out.println("neid :"+eid+ "\n name: "+ceo+ "\n Salary: "+salary);
	}
	

}
