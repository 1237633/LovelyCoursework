package sky.pro.java.course2.homework17.controllers;
import org.springframework.web.bind.annotation.*;
import sky.pro.java.course2.homework17.Employee;
import sky.pro.java.course2.homework17.Service.EmployeeService;
import java.util.Map;

@RestController


@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/delete")
    public Employee deleteEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        return employeeService.deleteEmployee(firstName, lastName);
    }

    @GetMapping("/printall")
    public Map<String, Employee> printAll() {
        return employeeService.printAll();
    }

}


