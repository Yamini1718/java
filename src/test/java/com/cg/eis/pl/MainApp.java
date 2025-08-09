package com.cg.eis.pl;

import java.util.Scanner;
import com.cg.eis.exception;
import com.cg.eis.bean.Employee;
import com.cg.eis.service.EmployeeService;
import com.cg.eis.service.EmployeeServiceImpl;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

     
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Employee Designation (Manager/Programmer/Associate): ");
        String designation = sc.nextLine();

       
        Employee emp = new Employee(id, name, salary, designation);

        
        EmployeeService service = new EmployeeServiceImpl();
        service.calculateInsuranceScheme(emp);

     
        System.out.println("\n" + emp.toString());

        sc.close();
    }
}
