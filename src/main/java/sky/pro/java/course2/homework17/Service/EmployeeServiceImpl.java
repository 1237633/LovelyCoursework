package sky.pro.java.course2.homework17.Service;

import org.springframework.stereotype.Service;
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
    public Employee addEmployee(String firstName, String lastName) {
        if (employeeBook.size() < EMPLOYEE_LIMIT) {
            Employee employee = new Employee(firstName, lastName);
            if (employeeBook.containsKey(inputToKey(firstName, lastName)) && employeeBook.containsValue(employee)) { //Проверять сразу на значение - долго, но могут попадаться тёзки с разными ключами.
                System.out.println("You are trying to add an existing employee! " + firstName + " " + lastName);
                throw new EmployeeAlreadyExistsException("Employee already exists!");
            }
            employeeBook.put(inputToKey(firstName, lastName), employee);
            System.out.println("Added " + employee);
            return employee;
        }
        System.out.println("Failed to add " + firstName + " " + lastName + ", storage is full!");
        throw new EmployeeStorageIsFullException("You reached the limit of employees!");


    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        if (employeeBook.containsKey(inputToKey(firstName, lastName))) {
            System.out.println("Deleted " + firstName + " " + lastName);
            return employeeBook.remove(inputToKey(firstName, lastName));
        } else {
            System.out.println("Deletion failed. No such employee: " + firstName + " " + lastName);
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee result = employeeBook.get(inputToKey(firstName, lastName));
        System.out.println("Attempt to find " + firstName + " " + lastName);
        if (result == null) {
            System.out.println("Failed to found. No such employee: " + firstName + " " + lastName);
            throw new EmployeeNotFoundException("There is no such employee!");
        }
        return result;
    }

    @Override
    public Map<String, Employee> printAll() {
        System.out.println("Printed employeBook");
        return employeeBook;
    }

    private static String inputToKey(String firstName, String lastName) {
        String result = firstName.trim() + lastName.trim();
        return result.toLowerCase();

    }

}


