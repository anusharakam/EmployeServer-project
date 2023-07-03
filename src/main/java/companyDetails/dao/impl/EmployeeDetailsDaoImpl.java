package companyDetails.dao.impl;

import companyDetails.dao.EmployeeDetailsDao;
import companyDetails.model.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public  class EmployeeDetailsDaoImpl implements  EmployeeDetailsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int employeeNewEntry(EmployeeDetails employee) {
        String query = " Insert into company_details(employeeId,name,email,password, department,salary,phoneNumber,address) values (?,?,?,?,?,?,?,?)";
        try {
            int a = jdbcTemplate.update(query, new Object[]{employee.getEmployeeId(), employee.getName(),employee.getEmail(), employee.getPassword(),employee.getDepartment(),employee.getSalary(),employee.getPhoneNumber(),employee.getAddress()});
            return a;
        } catch (Exception e) {
            System.out.println("there some issue while inserting");
            e.printStackTrace();
            return 0;
        }
    }
    @Override
    public List<EmployeeDetails> getEmployeeDetails() {
        List<EmployeeDetails> employeeList = jdbcTemplate.query("select * from company_details ", new RowMapper<EmployeeDetails>() {
            @Override
            public EmployeeDetails mapRow(ResultSet rs, int i) throws SQLException {
                EmployeeDetails employee = new EmployeeDetails();
                employee.setEmployeeId(rs.getInt("employeeId"));
                employee.setName(rs.getString("name"));
                employee.setEmail(rs.getString("email"));
                employee.setPassword(rs.getString("password"));
                employee.setDepartment(rs.getString("department"));
                employee.setSalary(rs.getString("salary"));
                employee.setPhoneNumber(rs.getString("phoneNumber"));
                employee.setAddress(rs.getString("address"));

                return employee;
            }
        });
        return employeeList;
    }

    @Override
    public EmployeeDetails findEmpById(int employeeId) {
        String sql = "select * from company_details where employeeId=?";
        EmployeeDetails employee = (EmployeeDetails) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(EmployeeDetails.class), employeeId);
        return employee;
    }

    @Override
    public int updateEmployeeById(EmployeeDetails employee ) {
        System.out.println(employee);
        String sql="update company_details set name=?,email=?,password=?, department=?,salary=?,phoneNumber=?,address=? where employeeId=?";
        try {
            int r= jdbcTemplate.update(sql, new Object[]{employee.getName(),employee.getEmail(), employee.getPassword(),employee.getDepartment(),employee.getSalary(),employee.getPhoneNumber(),employee.getAddress(),employee.getEmployeeId()});
            return r;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteEmployeeById(int employeeId) {
        String sql = "delete from company_details where employeeId=?";
        return jdbcTemplate.update(sql,employeeId);
    }

    @Override
    public int getCount() {
        String q="select count(*) from company_details";
        int count = getJdbcTemplate().queryForObject(q,Integer.class);
        return count;
    }
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    }





