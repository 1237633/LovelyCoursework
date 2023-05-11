package sky.pro.java.course2.homework17;

import java.util.Objects;

public class Employee {
    private final String firstname;
    private final String lastName;

    public Employee(String firstName, String lastName) {
        this.firstname = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

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

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }
}