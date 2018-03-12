package lab4;

import java.util.ArrayList;
import java.util.List;


public class HREmployee {
    private List<Employee> employees;

    public HREmployee() {
        employees = new ArrayList();
    }

    public void hireEmployee(String firstName, String lastName, String ssn) {
        Employee e = new Employee(firstName,lastName,ssn);
        employees.add(e);
        orientEmployee(e);
    }

    public void orientEmployee(Employee e){
        e.doFirstTimeOrientation("B101");
    }

    public void outputReport(String ssn){
       Employee e = null;
       //locate employee based on ssn
       for(Employee emp : employees){
           if (emp.getSsn().equals(ssn)){
               e = emp;
               break;
           } else {
               //end if ssn isn't found
               return;
           }
       }

    //run if ssn is found
    if (e.isMetWithHR()   && e.isMetDeptStaff())
        && e.isReviewedDeptPolicies() && e.isMovedIn()) {

        e.getReportService().outputReport();
    }
    }

    public List<Employee>getEmployees() {return employees;}

    public void setEmployees(List<Employee> employees) {this.employees = employees;}

    public static void main (String[] args){
        HREmployee hr = new HREmployee();
        hr.hireEmployee(John, Doe, "333-33-3333");
        System.out.println(hr.getEmployees());
    }

}