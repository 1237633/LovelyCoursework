package sky.pro.java.course2.homework17.Service;

import sky.pro.java.course2.homework17.Employee;

import java.util.Map;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, Integer departmentId, Integer salary);

    Employee deleteEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Map<String, Employee> printAll();
}
