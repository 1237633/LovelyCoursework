package sky.pro.java.course2.homework17.controllers;

import org.springframework.web.bind.annotation.*;
import sky.pro.java.course2.homework17.Employee;
import sky.pro.java.course2.homework17.Service.DepartmentsService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RequestMapping("/department")
@RestController

/*GET http://localhost:8080/department/{id}/employees
        — возвращает список сотрудников по департаменту.
        GET http://localhost:8080/department/{id}/salary/sum
        — возвращает сумму зарплат по департаменту.
        GET http://localhost:8080/department/{id}/salary/max
        — возвращает максимальную зарплату по департаменту.
        GET http://localhost:8080/department/{id}/salary/min
        — возвращает минимальную зарплату по департаменту.
        GET http://localhost:8080/department/employees
        — возвращает сотрудников,*/

public class DepartmentController {
    private final DepartmentsService departmentsService;

    public DepartmentController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }
    @GetMapping("/{id}/max")
    public Employee findMaxSal(@PathVariable Integer id) {
        return departmentsService.findMaxSal(id);
    }
    @GetMapping("/{id}/min")
    public Employee findMinSal(@PathVariable Integer id) {
        return departmentsService.findMinSal(id);
    }
    @GetMapping("/{id}/sum")
    public double findAvgSal(@PathVariable Integer id) {
        return departmentsService.summarySalary(id);
    }

    @GetMapping(value = "/{id}/employees")
    public Collection<Employee> all(@PathVariable Integer id) {
        return departmentsService.all(id);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> all() {
        return departmentsService.all();
    }

}
