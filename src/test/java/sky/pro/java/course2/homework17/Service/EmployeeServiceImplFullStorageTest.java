package sky.pro.java.course2.homework17.Service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sky.pro.java.course2.homework17.exceptions.EmployeeStorageIsFullException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceImplFullStorageTest {

    static private EmployeeService out;

    @BeforeAll
    static public void setUp() {
        out = new EmployeeServiceImpl();
    }


    @ParameterizedTest
    @Order(1)
    @MethodSource("provideParams")
    public void fillStorage(String name, String surname, int department, int salary) {
        out.addEmployee(name, surname, department, salary);

    }


    @Test
    @Order(2)
    public void throwsExceptionWhenFull() {
        Assertions.assertThrows(EmployeeStorageIsFullException.class, () -> out.addEmployee("Foo", "Bar", 1, 150));
    }

    public static Stream<Arguments> provideParams() {
        return Stream.of(Arguments.of("a", "b", 1, 10),
                Arguments.of("b", "c", 1, 10),
                Arguments.of("c", "d", 1, 10),
                Arguments.of("d", "e", 1, 10),
                Arguments.of("e", "f", 1, 10),
                Arguments.of("f", "g", 1, 10),
                Arguments.of("g", "h", 1, 100),
                Arguments.of("h", "i", 1, 100),
                Arguments.of("i", "j", 1, 100),
                Arguments.of("j", "k", 1, 100),
                Arguments.of("k", "l", 10, 10),
                Arguments.of("l", "m", 10, 10),
                Arguments.of("m", "n", 10, 10),
                Arguments.of("n", "o", 10, 10),
                Arguments.of("o", "p", 10, 10));
    }
}