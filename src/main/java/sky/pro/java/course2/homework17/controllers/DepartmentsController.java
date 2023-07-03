package sky.pro.java.course2.homework17.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.java.course2.homework17.Employee;
import sky.pro.java.course2.homework17.Service.DepartmentsService;

import java.util.Collection;
import java.util.List;
import java.util.Map;
@RequestMapping("/departments")
@RestController
public class DepartmentsController {

    private final DepartmentsService departmentsService;

    public DepartmentsController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }
    @GetMapping("/max")
    public Employee findMaxSal(@RequestParam Integer depId) {
        return departmentsService.findMaxSal(depId);
    }
    @GetMapping("/min")
    public Employee findMinSal(@RequestParam Integer depId) {
        return departmentsService.findMinSal(depId);
    }
    @GetMapping("/avg")
    public double findAvgSal(@RequestParam Integer depId) {
        return departmentsService.findAvgSal(depId);
    }

    @GetMapping(value = "/all", params = "depId")
    public Collection<Employee> all(@RequestParam Integer depId) {
        return departmentsService.all(depId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> all() {
        return departmentsService.all();
    }

}