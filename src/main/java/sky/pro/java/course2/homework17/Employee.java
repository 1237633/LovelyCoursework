package sky.pro.java.course2.homework17;

import java.util.Objects;

public class Employee {
    private final String firstname;
    private final String lastName;


    private Integer departmentId;
    private Integer salary;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getFirstname().equals(employee.getFirstname()) && getLastName().equals(employee.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstname(), getLastName());
    }

    public Employee(String firstName, String lastName, Integer departmentId, Integer salary) {
        this.firstname = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentId=" + departmentId +
                ", salary=" + salary +
                '}';
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public Integer getSalary() {
        return salary;
    }
}