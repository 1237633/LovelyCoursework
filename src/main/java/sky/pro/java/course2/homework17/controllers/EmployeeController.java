package sky.pro.java.course2.homework17.controllers;
import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.*;
import sky.pro.java.course2.homework17.Employee;
import sky.pro.java.course2.homework17.Service.EmployeeService;
import sky.pro.java.course2.homework17.exceptions.EmployeeAlreadyExistsException;

import java.util.Map;

@RestController


@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName, @RequestParam("depId") Integer depId, @RequestParam("salary") Integer salary) {
        return employeeService.addEmployee(firstName, lastName, depId, salary);
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

    @ExceptionHandler(RuntimeException.class)
    public void handleException(RuntimeException e) {
        throw new RuntimeException(e.getMessage(), e);
    }

}


