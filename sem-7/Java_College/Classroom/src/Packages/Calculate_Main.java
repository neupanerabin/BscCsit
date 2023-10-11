package Packages;
import Mypackage.Date_Calculate;

public class Calculate_Main {
    public static void main(String[] args) {
        Date_Calculate.Employee employee = new Date_Calculate().new Employee("John Doe", 50000.0, 2023, 10, 10);
        System.out.println(employee.getName());
    }
}
