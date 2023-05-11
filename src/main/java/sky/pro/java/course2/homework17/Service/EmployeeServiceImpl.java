package sky.pro.java.course2.homework17.Service;

import org.springframework.stereotype.Service;
import sky.pro.java.course2.homework17.Employee;
import sky.pro.java.course2.homework17.exceptions.EmployeeAlreadyExistsException;
import sky.pro.java.course2.homework17.exceptions.EmployeeNotFoundException;
import sky.pro.java.course2.homework17.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employeeBook = new ArrayList();
    private final int EMPLOYEE_LIMIT = 15;

    @Override
    public void addEmployee(String firstName, String lastName) {
        if (employeeBook.size() >= EMPLOYEE_LIMIT) {
            throw new EmployeeStorageIsFullException("Pay more taxes to have more employees!");
        }
        try {
            if (employeeBook.contains(findEmployee(firstName, lastName))) {
                throw new EmployeeAlreadyExistsException("You already have this employee: " + firstName + " " + lastName + "!");
            }
        } catch (EmployeeNotFoundException E) {  //при нормальной работе метода find внутри условного оператора, выкидывается эксепшн, если такой сотрудник не найден. При отстутствии такого сотрудника его следует добавить.
            employeeBook.add(new Employee(firstName, lastName));
            System.out.println("Added " + firstName + " " + lastName);
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeBook.remove(employee);
        System.out.println("Deleted " + employee + "!");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employeeBook) {
            if (employee.getFirstname().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("There is no Such employee: " + firstName + " " + lastName + "!");
    }

    @Override
    public List<Employee> printAll() {
        return employeeBook;
    }
}


