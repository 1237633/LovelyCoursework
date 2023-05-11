package sky.pro.java.course2.homework17.Service;

import sky.pro.java.course2.homework17.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(String firstName, String lastName);

    void deleteEmployee(Employee employee);

    Employee findEmployee(String firstName, String lastName);

    List<Employee> printAll();
}
