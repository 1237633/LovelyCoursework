package sky.pro.java.course2.homework17.Service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.java.course2.homework17.Employee;


import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentsServiceImplTest {
    private static final Map<String, Employee> TEST_EMPLOYEEBOOK = Map.of("VP", new Employee("V", "P", 1, 10000),
            "AI", new Employee("A", "I", 1, 15000),
            "DI", new Employee("D", "I", 2, 30000));

    private static final int DEP_FOR_TESTS = 1;
    private static final int UNEXISTING_DEP = 6;

    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private DepartmentsServiceImpl out;


    @Test
    void findMaxSal() {
        when(employeeServiceMock.printAll()).thenReturn(TEST_EMPLOYEEBOOK);
        Assertions.assertEquals(TEST_EMPLOYEEBOOK.get("AI"), out.findMaxSal(DEP_FOR_TESTS));
    }

    @Test
    void findMinSal() {
        when(employeeServiceMock.printAll()).thenReturn(TEST_EMPLOYEEBOOK);
        Assertions.assertEquals(TEST_EMPLOYEEBOOK.get("VP"), out.findMinSal(DEP_FOR_TESTS));
    }

    @Test
    void findAvgSal() {
        when(employeeServiceMock.printAll()).thenReturn(TEST_EMPLOYEEBOOK);
        double expected = TEST_EMPLOYEEBOOK.values().stream().filter(e -> e.getDepartmentId() == DEP_FOR_TESTS).mapToInt(e -> e.getSalary()).average().getAsDouble();
        Assertions.assertEquals(expected, out.findAvgSal(DEP_FOR_TESTS));
    }

    @Test
    void summarySalary() {
        when(employeeServiceMock.printAll()).thenReturn(TEST_EMPLOYEEBOOK);
        double expected = TEST_EMPLOYEEBOOK.values().stream().filter(e -> e.getDepartmentId() == 1).mapToInt(e -> e.getSalary()).sum();
        Assertions.assertEquals(expected, out.summarySalary(DEP_FOR_TESTS));
    }

    @Test
    void all() {
        when(employeeServiceMock.printAll()).thenReturn(TEST_EMPLOYEEBOOK);
        Map<Integer, List<Employee>> expected = TEST_EMPLOYEEBOOK.values()
                .stream()
                .collect(Collectors.groupingBy(e -> e.getDepartmentId(), Collectors.toList()));
        Assertions.assertEquals(expected, out.all());
    }

    @Test
    void allInDepartmment() {
        when(employeeServiceMock.printAll()).thenReturn(TEST_EMPLOYEEBOOK);
        Collection<Employee> expected = TEST_EMPLOYEEBOOK.values()
                .stream()
                .collect(Collectors.groupingBy(e -> e.getDepartmentId(), Collectors.toList())).get(DEP_FOR_TESTS);
        Assertions.assertIterableEquals(expected, out.all(DEP_FOR_TESTS));
    }

    @Test
    void throwsNPE() {
        Assertions.assertThrows(NullPointerException.class, () -> out.findMaxSal(UNEXISTING_DEP));
        Assertions.assertThrows(NullPointerException.class, () -> out.findMinSal(UNEXISTING_DEP));
        Assertions.assertThrows(NullPointerException.class, () -> out.findAvgSal(UNEXISTING_DEP));
        Assertions.assertThrows(NullPointerException.class, () -> out.summarySalary(UNEXISTING_DEP));
    }

}