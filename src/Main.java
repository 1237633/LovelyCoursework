import java.awt.image.ReplicateScaleFilter;

public class Main {
    public static void main(String[] args) {
        Employee[] employeeBook = new Employee[10];

      for (int i = 0; i < 10; i++) {
          employeeBook[i] = new Employee(RandomTools.generateRandomName(), RandomTools.generateRandomNumber(1, 6), RandomTools.generateRandomNumber(100000, 200001));

      }
      EmployeeService.printAllEmployees(employeeBook);
        System.out.println("Total salary per month: " + EmployeeService.getTotalSalaryPerMonth(employeeBook));
        System.out.println("And our looser is: " + EmployeeService.getCheapestEmployee(employeeBook));
        System.out.println("And the lucky guy is: " + EmployeeService.getTheMostExpensiveEmployee(employeeBook));
        System.out.println("Average salary: " + EmployeeService.getAvgSalary(employeeBook));
        EmployeeService.printAllNames(employeeBook);
        EmployeeService.indexSalary(employeeBook, 20);
        EmployeeService.printAllEmployees(employeeBook);

    }
}

