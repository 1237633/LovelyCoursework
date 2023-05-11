package sky.pro.java.course2.homework17.controllers;

import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sky.pro.java.course2.homework17.Employee;
import sky.pro.java.course2.homework17.Service.EmployeeService;
import sky.pro.java.course2.homework17.exceptions.EmployeeAlreadyExistsException;
import sky.pro.java.course2.homework17.exceptions.EmployeeNotFoundException;
import sky.pro.java.course2.homework17.exceptions.EmployeeStorageIsFullException;

import java.util.List;

@RestController


@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        employeeService.addEmployee(firstName, lastName);
        return employeeService.findEmployee(firstName, lastName);

    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/delete")
    public Employee deleteEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        try {
            return employeeService.findEmployee(firstName, lastName);
        } finally {
            employeeService.deleteEmployee(employeeService.findEmployee(firstName, lastName));
        }
    }

    @GetMapping("/printall")
    public List<Employee> printAll() {
        return employeeService.printAll();
    }

}


