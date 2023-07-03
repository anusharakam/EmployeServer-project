package companyDetails.dao;

import companyDetails.model.EmployeeDetails;

import java.util.List;

public interface EmployeeDetailsDao {
     int employeeNewEntry(EmployeeDetails employeeDetails);

     List<EmployeeDetails> getEmployeeDetails();

     EmployeeDetails findEmpById(int id);

     int updateEmployeeById(EmployeeDetails employeeDetails);

     int deleteEmployeeById(int employeeId);

     int getCount();

}
