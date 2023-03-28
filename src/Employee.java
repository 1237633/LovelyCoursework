import java.util.Objects;

public class Employee {
    private final String FULL_NAME;
    private int departmentId;
    private int salary;
    private static int counter;
    private final int id;

    public Employee(String fullName, int departmentId, int salary){
        this.FULL_NAME = fullName;
        this.departmentId = departmentId;
        this.salary = salary;
        id = counter;
        counter++;
    }

    public String getFullName() {
        return FULL_NAME;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee: " + FULL_NAME + ", department id: " + departmentId + ", salary: " + salary + ", employee id: " + id;
    }

    @Override
    public boolean equals(Object o) {  //У каждого сторудника уникальный id
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
