package companyDetails.service;

import companyDetails.model.EmployeeDetails;

import java.util.List;

public interface EmployeeDetailsService {

     int employeeNewEntry(EmployeeDetails employeeDetails);
     List<EmployeeDetails> getEmployeeDetails();
    EmployeeDetails findEmpById(int employeeId);
   int deleteEmployeeById(int employeeId);
    int updateEmployeeById(EmployeeDetails employeeDetails);
    int getCount();


}





