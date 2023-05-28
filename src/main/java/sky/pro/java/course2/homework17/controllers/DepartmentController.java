package sky.pro.java.course2.homework17.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.java.course2.homework17.Employee;
import sky.pro.java.course2.homework17.Service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;
@RequestMapping("/departments")
@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("/max")
    public Employee findMaxSal(@RequestParam Integer depId) {
        return departmentService.findMaxSal(depId);
    }
    @GetMapping("/min")
    public Employee findMinSal(@RequestParam Integer depId) {
        return departmentService.findMinSal(depId);
    }
    @GetMapping("/avg")
    public double findAvgSal(@RequestParam Integer depId) {
        return departmentService.findAvgSal(depId);
    }

    @GetMapping(value = "/all", params = "depId")
    public Collection<Employee> all(@RequestParam Integer depId) {
        return departmentService.all(depId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> all() {
        return departmentService.all();
    }

}