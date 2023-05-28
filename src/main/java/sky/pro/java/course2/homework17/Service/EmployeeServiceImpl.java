package sky.pro.java.course2.homework17.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sky.pro.java.course2.homework17.Employee;
import sky.pro.java.course2.homework17.exceptions.EmployeeAlreadyExistsException;
import sky.pro.java.course2.homework17.exceptions.EmployeeNotFoundException;
import sky.pro.java.course2.homework17.exceptions.EmployeeStorageIsFullException;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Map<String, Employee> employeeBook = new HashMap();
    private static final int EMPLOYEE_LIMIT = 15;

    @Override
    public Employee addEmployee(String firstName, String lastName, Integer departmentId, Integer salary) {
        if (employeeBook.size() < EMPLOYEE_LIMIT) {
            Employee employee = new Employee(firstName, lastName, departmentId, salary);
            if (employeeBook.containsKey(inputToKey(firstName, lastName)) && employeeBook.containsValue(employee)) { //Проверять сразу на значение - долго, но могут попадаться тёзки с разными ключами.
                throw new EmployeeAlreadyExistsException("Employee " + firstName + " " + lastName + " already exists!");
            }
            employeeBook.put(inputToKey(firstName, lastName), employee);
            System.out.println("Added " + employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException("Failed to add " + firstName + " " + lastName + ". You reached the limit of employees!");


    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        if (employeeBook.containsKey(inputToKey(firstName, lastName))) {
            System.out.println("Deleted " + firstName + " " + lastName);
            return employeeBook.remove(inputToKey(firstName, lastName));
        } else {
            throw new EmployeeNotFoundException("Deletion failed! No such employee!");
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee result = employeeBook.get(inputToKey(firstName, lastName));
        System.out.println("Attempt to find " + firstName + " " + lastName);
        if (result == null) {
            throw new EmployeeNotFoundException("There is no such employee!");
        }
        return result;
    }

    @Override
    public Map<String, Employee> printAll() {
        System.out.println("Printed employeeBook");
        return employeeBook;
    }

    private static String inputToKey(String firstName, String lastName) {
        String result = firstName.trim() + lastName.trim();
        return result.toLowerCase();

    }


}


