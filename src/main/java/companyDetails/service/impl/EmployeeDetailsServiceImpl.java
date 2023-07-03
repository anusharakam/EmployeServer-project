package companyDetails.service.impl;


import companyDetails.dao.EmployeeDetailsDao;
import companyDetails.dao.impl.EmployeeDetailsDaoImpl;
import companyDetails.model.EmployeeDetails;
import companyDetails.service.EmployeeDetailsService;

import java.util.List;

public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

    private EmployeeDetailsDaoImpl employeeDetailsDao;

    @Override
    public int employeeNewEntry(EmployeeDetails employeeDetails) {
        System.out.println(employeeDetails);
        int a = employeeDetailsDao.employeeNewEntry(employeeDetails);
        return a;
    }

    @Override
    public List<EmployeeDetails> getEmployeeDetails() {
        return employeeDetailsDao.getEmployeeDetails();
    }

    @Override
    public EmployeeDetails findEmpById(int employeeId) {
        return employeeDetailsDao.findEmpById(employeeId);
    }

    @Override
    public int deleteEmployeeById(int employeeId) {
        return employeeDetailsDao.deleteEmployeeById(employeeId);
    }

    @Override
    public int updateEmployeeById(EmployeeDetails employeeDetails) {
        return employeeDetailsDao.updateEmployeeById(employeeDetails);
    }
    @Override
    public int getCount() {
        return employeeDetailsDao.getCount();
    }

    public EmployeeDetailsDaoImpl getEmployeeDetailsDao() {
        return employeeDetailsDao;
    }

    public void setEmployeeDetailsDao(EmployeeDetailsDaoImpl employeeDetailsDao) {
        this.employeeDetailsDao = employeeDetailsDao;
    }
}








