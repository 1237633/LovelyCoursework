public class EmployeeBook {
    private Employee[] employeeBook;

    public EmployeeBook(int length){
        employeeBook = new Employee[length];
    }


    public void fillWithRandom(){
        for (int i = 0; i < employeeBook.length; i++) {
            employeeBook[i] = new Employee(RandomTools.generateRandomName(), RandomTools.generateRandomNumber(1, 6), RandomTools.generateRandomNumber(100000, 200001));
        }
    }
    public void printAllEmployees (){
        if(employeeBook != null){
        for (Employee employee : employeeBook) {
            System.out.println(employee);
        }
        }
    }

    public  int getTotalSalaryPerMonth(){
        int sum = 0;
        if (employeeBook != null){
        for (Employee employee : employeeBook) {
           if(employee != null) {
               sum += employee.getSalary();
           }
           }
        }
        return sum;
    }

    public Employee getCheapestEmployee(Employee[] employees){
        Employee cheapest = null;
        if (employees != null) {
            cheapest = employees[0];
            for (int i = 0; i < employees.length - 1; i++) {
                if (employees[i + 1] != null && cheapest.getSalary() > employees[i + 1].getSalary()) {
                    cheapest = employees[i + 1];
                }
            }
        }
        return cheapest;
    }

    public Employee getTheMostExpensiveEmployee(Employee[] employees){
        Employee theExpensiveOne = null;
                if(employees != null) {
                    theExpensiveOne = employees[0];
                    for (int i = 0; i < employees.length - 1; i++) {
                        if (employees[i + 1] != null && theExpensiveOne.getSalary() < employees[i + 1].getSalary()) {
                            theExpensiveOne = employees[i + 1];
                        }
                    }
                }
        return theExpensiveOne;
    }

    public float getAvgSalary(){
        if(employeeBook != null) {
            int counterOfEmployees = 0;
            for (int i = 0; i < employeeBook.length; i++) {
                if (employeeBook[i] != null) {
                    counterOfEmployees++;
                }
            }
            return (float)getTotalSalaryPerMonth()/counterOfEmployees;
        }
        return 0f;
    }

    public void printAllNames(Employee[] employees){
        for (int i = 0; i < employees.length; i++) {
            System.out.println(i+1 + ". " + employees[i].getFullName());
        }
    }

    public void indexSalary(Employee[] employees, int indexingPercentage){
       if(employees != null) {
           if (indexingPercentage <= -100) {
               throw new IllegalArgumentException("You should fire this employee, not make him suffer!");
           }
           for (Employee employee : employees) {
               employee.setSalary(employee.getSalary() + employee.getSalary() * indexingPercentage / 100);
           }
       }
    }

    public Employee[] getAllEmployeesOfDepartment(int departmentId) {
        int counterOfEmployees = 0;
        Employee[] employeesOfDepartment = null;

        for (int i = 0; i < employeeBook.length; i++) {
            if (employeesOfDepartment[i].getDepartmentId() == departmentId) {
                counterOfEmployees++;
            }
        }
        if (counterOfEmployees > 0) {
            employeesOfDepartment = new Employee[counterOfEmployees];

            counterOfEmployees = 0;
            for (int i = 0; i < employeeBook.length; i++) {
                if (employeeBook[i].getDepartmentId() == departmentId) {
                    employeesOfDepartment[counterOfEmployees] = employeeBook[i];
                    counterOfEmployees++;
                }
            }
        }
        return employeesOfDepartment;

    }
    public void printAllEmployees(int departmentId){
       Employee[] employeesOfDepartment = getAllEmployeesOfDepartment(departmentId);
       if(employeesOfDepartment != null) {
           for (Employee employee : employeesOfDepartment) {
               System.out.println("Name: " + employee.getFullName() + ", salary: " + employee.getSalary() + ", id: " + employee.getId());
           }
         }
    }

    public Employee getCheapestEmployee(Employee[] employees, int departmentId){
        return getCheapestEmployee(getAllEmployeesOfDepartment(employees, departmentId));

    }

    public Employee getTheMostExpensiveEmployee(Employee[] employees, int departmentId){
        return getTheMostExpensiveEmployee(getAllEmployeesOfDepartment(employees, departmentId));
    }

    public int getTotalSalaryPerMonth(int departmentId){
        return getTotalSalaryPerMonth(getAllEmployeesOfDepartment(departmentId));

    }

    public float getAvgSalary(Employee[] employees, int departmentId){
        return (float)getAvgSalary(getAllEmployeesOfDepartment(employees, departmentId));
    }

    public void indexSalary(Employee[] employees, int departmentId, int indexingPercentage){
        indexSalary(getAllEmployeesOfDepartment(employees, departmentId), indexingPercentage);
    }

    public void printHigherSalary(Employee[] employees, int salary){
        if (employees != null){
            for (int i = 0; i < employees.length; i++) {
                if(employees[i].getSalary() >= salary){
                    System.out.println(employees[i]);
                }
            }
        }
    }

    public void printLowerSalary(Employee[] employees, int salary){
        if (employees != null){
            for (int i = 0; i < employees.length; i++) {
                if(employees[i].getSalary() < salary){
                    System.out.println(employees[i]);
                }
            }
        }
    }

}

