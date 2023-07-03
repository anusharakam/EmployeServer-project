package companyDetails.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import companyDetails.model.EmployeeDetails;
import companyDetails.service.impl.EmployeeDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class EmployeeDetailsRestController {
    @Autowired
    private EmployeeDetailsServiceImpl employeeDetailsService;

 @GetMapping(value = "/employeeDetailsInJson", headers = "Accept=application/Json")
    public String employeeDetailsInJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String list = objectMapper.writeValueAsString(employeeDetailsService.getEmployeeDetails());
        System.out.println(list);
        return list;
    }

    @GetMapping("/getByIdInJson/{employeeId}")
    public String getById(@PathVariable int employeeId) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String employee = objectMapper.writeValueAsString(employeeDetailsService.findEmpById(employeeId));
        System.out.println(employee);
        return employee;
    }

    /*@GetMapping(value = "/allDetails")
    public List<EmployeeDetails> employeeDetailsInJson() {
        return employeeDetailsService.getEmployeeDetails();
    }

    @GetMapping("/getById/{employeeId}")
    public EmployeeDetails getById(@PathVariable int employeeId) {
        return employeeDetailsService.findEmpById(employeeId);
    }*/

    @PutMapping("/Update")
    public int update(@RequestBody EmployeeDetails employeeDetails) {
        return employeeDetailsService.updateEmployeeById(employeeDetails);
    }

    @DeleteMapping("/delete/{employeeId}")
    public int delete(@PathVariable int employeeId) {
        return employeeDetailsService.deleteEmployeeById(employeeId);
    }

    @PostMapping("/saveDataFromClient")
    public int insert(@RequestBody EmployeeDetails employeeDetails){
        System.out.println(employeeDetails);
        return employeeDetailsService.employeeNewEntry(employeeDetails);
    }
}