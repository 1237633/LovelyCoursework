import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      int countOfEmployees = 10;
      EmployeeBook employeeBook = new EmployeeBook(countOfEmployees);
      employeeBook.fillWithRandom();

     Scanner scan = new Scanner(System.in);


        //----------------------------------------------------------------------------
        // TESTS ↓

        employeeBook.printAllEmployees();
        System.out.println("______________________________________________________________________________");
        System.out.println(employeeBook.getTotalSalaryPerMonth());
        employeeBook.indexSalary(20);
        employeeBook.printAllEmployees();
        System.out.println(employeeBook.getTotalSalaryPerMonth());
        System.out.println(employeeBook.getTotalSalaryPerMonth(2));
        System.out.println(employeeBook.getAvgSalary());
        System.out.println(employeeBook.getAvgSalary(2));
        System.out.println(employeeBook.getCheapestEmployee());
        System.out.println(employeeBook.getCheapestEmployee(2));
        System.out.println(employeeBook.getTheMostExpensiveEmployee());
        System.out.println(employeeBook.getTheMostExpensiveEmployee(2));
        employeeBook.indexSalary(2,20);
        employeeBook.printAllEmployees(2);
        System.out.println("Higher:");
        employeeBook.printHigherSalary(175000);
        System.out.println("Lower:");
        employeeBook.printLowerSalary(175000);
      System.out.println("_______________________________");
     System.out.println("Delete by id: ");
      employeeBook.removeEmployee(scan.nextLine());
        employeeBook.printAllEmployees();
      System.out.println("Delete  by name: ");
      employeeBook.removeEmployee(scan.nextLine());
      employeeBook.printAllEmployees();
       System.out.println("Add: ");
        employeeBook.addEmployee("Allah", 4, 999999999);
        employeeBook.printAllEmployees();
        System.out.println("____________________________");
        System.out.println("Change salary. Enter: name, salary");
        employeeBook.setSalary(scan.nextLine(), Integer.parseInt(scan.nextLine())); //non checked if input is number
        employeeBook.printAllEmployees();
        System.out.println("Change department. Enter: name, department №");
        employeeBook.setDepartment(scan.nextLine(), Integer.parseInt(scan.nextLine())); //non checked if input is number
        scan.close();
        employeeBook.printAllEmployees(false);
        System.out.println("________________________________________________________________");
        employeeBook.printAllEmployees(true);
        System.out.println();
        employeeBook.printAllNames();



    }
}

