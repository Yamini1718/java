
package com.cg.eis.service;

import com.cg.eis.bean.Employee;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void calculateInsuranceScheme(Employee emp) {
        double salary = emp.getSalary();
        String designation = emp.getDesignation().toLowerCase();

        String scheme;

        if (salary > 50000 && designation.equals("manager")) {
            scheme = "Platinum";
        } else if (salary > 20000 && salary <= 50000 && designation.equals("programmer")) {
            scheme = "Gold";
        } else if (salary > 10000 && salary <= 20000 && designation.equals("associate")) {
            scheme = "Silver";
        } else {
            scheme = "No Scheme";
        }

        emp.setInsuranceScheme(scheme);
    }
}
