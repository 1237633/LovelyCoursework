package sky.pro.java.course2.homework17.Service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import sky.pro.java.course2.homework17.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Repository
public class DepartmentsServiceImpl implements DepartmentsService {

    private final EmployeeService employeeService;

    public DepartmentsServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMaxSal(Integer depId) {
        return all(depId).stream().max(Comparator.comparingInt(e -> e.getSalary())).get();
    }

    @Override
    public Employee findMinSal(Integer depId) {
        return all(depId).stream().min(Comparator.comparingInt(e -> e.getSalary())).get();
    }

    @Override
    public double findAvgSal(Integer depId) {
        return all(depId).stream().mapToInt(e -> e.getSalary()).average().getAsDouble();
    }

    @Override
    public double summarySalary(Integer depId) {
        return all(depId).stream().mapToInt(e -> e.getSalary()).sum();
    }

    @Override
    public Collection<Employee> all(Integer depId) {
       return all().get(depId);
    }

    @Override
    public Map<Integer, List<Employee>> all() {
        return employeeService.printAll().values()
                .stream()
                .collect(Collectors.groupingBy(e -> e.getDepartmentId(), Collectors.toList()));
    }

}
