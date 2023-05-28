package sky.pro.java.course2.homework17.Service;

import sky.pro.java.course2.homework17.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee findMaxSal(Integer depId);

    Employee findMinSal(Integer depId);

    double findAvgSal(Integer depId);

    Collection<Employee> all(Integer depId);

    Map<Integer, List<Employee>> all();
}
