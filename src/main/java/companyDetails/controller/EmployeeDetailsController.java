
package companyDetails.controller;
import companyDetails.model.EmployeeDetails;
import companyDetails.service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Controller
@RequestMapping("/")
public class EmployeeDetailsController {
    @Autowired
    private EmployeeDetailsService employeeService;

    @RequestMapping(value="/home, method =RequestMethod.Get")
    public String homePage() {
        return "home";
    }

    @GetMapping(value = "/form")
    public String companyApplicationForm(Model model) {
        EmployeeDetails details=new EmployeeDetails();
        int count=employeeService.getCount();
        details.setEmployeeId(count+1);
        model.addAttribute("employeeForm", details);
        return "applicationForm";
    }
    @PostMapping("/saveData")
    public  String create(@ModelAttribute("employeeForm")EmployeeDetails employeeDetails, Model model){
        int count = employeeService.employeeNewEntry(employeeDetails);
        if( count > 0) {
            model.addAttribute("save", "success");
        }else {
            model.addAttribute("save","error");
        }
        return  "successful";
    }
    @RequestMapping("/viewEmployeeList")
    public ModelAndView getCompanyDetails(ModelAndView m) {
        List<EmployeeDetails> list = employeeService.getEmployeeDetails();
        m.addObject("list", list);
        m.setViewName("viewEmployeeList");
        return m;
    }
    @RequestMapping(value = "/ById/{employeeId}", method = RequestMethod.GET)
    public String getUserById(@PathVariable int employeeId, Model model) {
        EmployeeDetails employee = employeeService.findEmpById(employeeId);
        model.addAttribute("employee", employee);
        return "employeeData";
    }
    @GetMapping(value = "/editEmployee/{employeeId}")
    public String updateCompany(@PathVariable int employeeId, Model model) {
        EmployeeDetails employee = employeeService.findEmpById(employeeId);
        model.addAttribute("employee",employee );
        return "update";
    }
    @PostMapping("/updateEmployee")
   public String update(@ModelAttribute("employee") EmployeeDetails employeeDetails, Model model)
    {
        int counter = employeeService.updateEmployeeById(employeeDetails);
        System.out.println(counter);
        if (counter > 0) {
            model.addAttribute("msg", " updation done successfully");
        } else {
            model.addAttribute("msg", "not updated successfully");
        }
        return "updateSuccess";
    }
    @RequestMapping(value = "/deleteEmployee/{employeeId}", method = RequestMethod.GET)
    public String deleteCompany(@PathVariable int employeeId, Model model) {
        int count= employeeService.deleteEmployeeById(employeeId);
        if (count>0){
            model.addAttribute("msg","deleted successfully");
        }
        else {
            model.addAttribute("msg","not deleted ");
        }
        return "deleteSuccess";
    }
}




