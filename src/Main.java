public class Main {
    public static void main(String[] args) {
      EmployeeBook employeeBook = new EmployeeBook(10);
      employeeBook.fillWithRandom();


      //----------------------------------------------------------------------------

      employeeBook.printAllEmployees();
      employeeBook.getTotalSalaryPerMonth();
      /*employeeBook.printAllEmployees;
      System.out.println("____________________________________");
        System.out.println("Total salary per month: " + EmployeeBook.getTotalSalaryPerMonth(employeeBook));
        System.out.println("And our looser is: " + EmployeeBook.getCheapestEmployee(employeeBook));
        System.out.println("And the lucky guy is: " + EmployeeBook.getTheMostExpensiveEmployee(employeeBook));
        System.out.println("Average salary: " + EmployeeBook.getAvgSalary(employeeBook));
        EmployeeBook.printAllNames(employeeBook);
        EmployeeBook.indexSalary(employeeBook, 20);
        EmployeeBook.printAllEmployees(employeeBook);
        System.out.println();
        EmployeeBook.printAllEmployees(EmployeeBook.getAllEmployeesOfDepartment(employeeBook, 2));
        System.out.println();
        EmployeeBook.printAllEmployees(employeeBook, 2);
        System.out.println();
        System.out.println(EmployeeBook.getCheapestEmployee(employeeBook, 2));
        System.out.println();
        System.out.println(EmployeeBook.getTheMostExpensiveEmployee(employeeBook, 2));
      System.out.println();
        System.out.println(EmployeeBook.getTotalSalaryPerMonth(employeeBook, 2));
      System.out.println();
      System.out.println(EmployeeBook.getAvgSalary(employeeBook,2));
      System.out.println();
      EmployeeBook.indexSalary(employeeBook, 2, 10);
      EmployeeBook.printAllEmployees(EmployeeBook.getAllEmployeesOfDepartment(employeeBook, 2));
      System.out.println("↑");
      EmployeeBook.printHigherSalary(employeeBook, 170000);
      System.out.println(" ↓");
      EmployeeBook.printLowerSalary(employeeBook, 160000);*/
    }
}

