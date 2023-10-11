package Mypackage;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date_Calculate {

    public class Employee {
        private String name;
        private double salary;
        private Date hireDate;

        public Employee(String n, double s, int year, int month, int day) {
            name = n;
            salary = s;

            // Create a Calendar instance to represent the hire date
            Calendar calendar = new GregorianCalendar(year, month - 1, day);
            hireDate = new Date(calendar.getTimeInMillis());
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public Date getHireDate() {
            return hireDate;
        }
       
    }
}
