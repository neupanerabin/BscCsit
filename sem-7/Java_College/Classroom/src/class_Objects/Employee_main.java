package class_Objects;

public class Employee_main {
	public static void main(String[] args) {
		
		Employee em = new Employee();
		em.eid= 1;
		em.ceo = "Rabin";
		em.salary = 100;
		
		Employee ems = new Employee();
		ems.eid= 1;
		ems.ceo = "sangarsha";
		ems.salary = 100;
		
		em.show();
		ems.show();
		
	}

}
