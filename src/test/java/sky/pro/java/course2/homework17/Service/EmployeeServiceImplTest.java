package sky.pro.java.course2.homework17.Service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.aop.target.AbstractBeanFactoryBasedTargetSource;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.context.ConfigurableApplicationContext;
import sky.pro.java.course2.homework17.Employee;
import sky.pro.java.course2.homework17.EmployeeKey;
import sky.pro.java.course2.homework17.exceptions.BadRequestException;
import sky.pro.java.course2.homework17.exceptions.EmployeeAlreadyExistsException;
import sky.pro.java.course2.homework17.exceptions.EmployeeNotFoundException;
import sky.pro.java.course2.homework17.exceptions.EmployeeStorageIsFullException;

import java.beans.Transient;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    private final String NAME = "Foo";
    private final String WRONG_NAME = "Foo2";
    private final String SURNAME = "Bar";
    private final String WRONG_SURNAME = "#Bar";
    private final Integer DEPARTMENT = 2;
    private final Integer SALARY = 15000;
    private final String KEY = "foobar";

    private EmployeeService out;

    @BeforeEach
    public void setUp() {
        out = new EmployeeServiceImpl();
        System.out.println("---------");
    }

    @Test
    public void addEmployeeNormal() {
        Employee actual = out.addEmployee(NAME, SURNAME, DEPARTMENT, SALARY);
        Employee expected = new Employee(NAME, SURNAME, DEPARTMENT, SALARY);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void employeeKeyNormal() {
        String actual = EmployeeKey.inputToKey(NAME, SURNAME);
        String expected = KEY;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void employeeKeyThrowsExceptionOnWrongNameSymbols() {
        Assertions.assertThrows(BadRequestException.class, () -> EmployeeKey.inputToKey(WRONG_NAME, SURNAME));
    }

    @Test
    public void employeeKeyThrowsExceptionOnWrongSurnameSymbols() {
        Assertions.assertThrows(BadRequestException.class, () -> EmployeeKey.inputToKey(NAME, WRONG_SURNAME));
    }



    @Test
    public void throwsExceptionWhenDuplicating() {
        out.addEmployee(NAME, SURNAME, DEPARTMENT, SALARY);
        Assertions.assertThrows(EmployeeAlreadyExistsException.class, () -> out.addEmployee(NAME, SURNAME, DEPARTMENT, SALARY));
    }

    @Test
    public void deleteEmployee() {
        Employee expected = out.addEmployee(NAME, SURNAME, DEPARTMENT, SALARY);
        Employee actual = out.deleteEmployee(NAME, SURNAME);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void throwsExceptionWhenDeletingUnexisting() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.deleteEmployee(NAME, SURNAME));
    }

    @Test
    public void findEmployee() {
        out.addEmployee("A", "B", 11, 150);
        Employee expected = out.addEmployee(NAME, SURNAME, DEPARTMENT, SALARY);
        Employee actual = out.findEmployee(NAME, SURNAME);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void throwsExceptionWhenSearchingUnexisting() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee(NAME, SURNAME));
    }

}