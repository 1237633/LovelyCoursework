public class EmployeeBook {
    private Employee[] employeeBook;

    public EmployeeBook(int length){
        employeeBook = new Employee[length];
    }


    public boolean depIsNotNull(int depId){
        return getAllEmployeesOfDepartment(depId) != null;
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

    public Employee getCheapestEmployee(){
        Employee cheapest = null;
        if (employeeBook != null) {
            cheapest = employeeBook[0];
            for (int i = 0; i < employeeBook.length - 1; i++) {
                if (employeeBook[i + 1] != null && cheapest.getSalary() > employeeBook[i + 1].getSalary()) {
                    cheapest = employeeBook[i + 1];
                }
            }
        }
        return cheapest;
    }

    public Employee getTheMostExpensiveEmployee(){
        Employee theExpensiveOne = null;
                if(employeeBook != null) {
                    theExpensiveOne = employeeBook[0];
                    for (int i = 0; i < employeeBook.length - 1; i++) {
                        if (employeeBook[i + 1] != null && theExpensiveOne.getSalary() < employeeBook[i + 1].getSalary()) {
                            theExpensiveOne = employeeBook[i + 1];
                        }
                    }
                }
        return theExpensiveOne;
    }

    public float getAvgSalary(){
        if(employeeBook != null) {
            int counterOfEmployees = 0; // array may be not full
            for (Employee employee: employeeBook) {
                if (employee != null) {
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

    public void indexSalary(int indexingPercentage){
       if(employeeBook != null) {
           if (indexingPercentage <= -100) {
               throw new IllegalArgumentException("You should fire this employee, not make him suffer!");
           }
           for (Employee employee : employeeBook) {
               if(employee != null){
               employee.setSalary(employee.getSalary() + employee.getSalary() * indexingPercentage / 100);
               }
           }
       }
    }

    public EmployeeBook getAllEmployeesOfDepartment(int departmentId) {
        int counterOfEmployees = 0;
        EmployeeBook employeesOfDepartment = null;

        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null && employeeBook[i].getDepartmentId() == departmentId) {
                counterOfEmployees++;
            }
        }
        if (counterOfEmployees > 0) {
            employeesOfDepartment = new EmployeeBook(counterOfEmployees);

            counterOfEmployees = 0;
            for (int i = 0; i < employeeBook.length; i++) {
                if (employeeBook[i] != null && employeeBook[i].getDepartmentId() == departmentId) {
                    employeesOfDepartment.employeeBook[counterOfEmployees] = employeeBook[i];
                    counterOfEmployees++;
                }
            }
        }
        return employeesOfDepartment;

    }
    public void printAllEmployees(int departmentId){
       EmployeeBook employeesOfDepartment = getAllEmployeesOfDepartment(departmentId);
       if(employeesOfDepartment != null) {
           for (Employee employee : employeesOfDepartment.employeeBook) {
               System.out.println("Name: " + employee.getFullName() + ", salary: " + employee.getSalary() + ", id: " + employee.getId());
           }
         }
    }

    public Employee getCheapestEmployee(int departmentId){
        if (depIsNotNull(departmentId)) {
            return getAllEmployeesOfDepartment(departmentId).getCheapestEmployee();
        }
        return null;

    }

    public Employee getTheMostExpensiveEmployee(int departmentId){
        if (depIsNotNull(departmentId)) {
            return getAllEmployeesOfDepartment(departmentId).getTheMostExpensiveEmployee();
        }
        return null;
    }

    public int getTotalSalaryPerMonth(int departmentId){

        if(depIsNotNull(departmentId)) {
            return getAllEmployeesOfDepartment(departmentId).getTotalSalaryPerMonth();
        }
        return 0;
    }

    public float getAvgSalary(int departmentId){
        if (depIsNotNull(departmentId)) {
            return (float) getAllEmployeesOfDepartment(departmentId).getAvgSalary();
        }
        return 0f;
    }

    public void indexSalary(int departmentId, int indexingPercentage){
        if (depIsNotNull(departmentId)) {
            getAllEmployeesOfDepartment(departmentId).indexSalary(indexingPercentage);
        }
    }

    public void printHigherSalary(int salary){
        if (employeeBook != null){
            for (Employee employee: employeeBook) {
                if(employee != null && employee.getSalary() >= salary){
                    System.out.println(employee);
                }
            }
        }
    }

    public void printLowerSalary(int salary){
        if (employeeBook != null){
            for (Employee employee: employeeBook) {
                if(employee != null && employee.getSalary() < salary){
                    System.out.println(employee);
                }
            }
        }
    }

    public int getPosition(int id){ //now id = [index], but what if not?
        if(employeeBook != null && id >= 0){
            for (int i = 0; i < employeeBook.length; i++) {
                if(employeeBook[i] == null){
                    continue;
                }
                if(employeeBook[i].getId() == id){
                    return i;
                }
            }
        }
        return -1;
    }

    public int getPosition(String name){
        if(employeeBook != null && name != null){
            for (int i = 0; i < employeeBook.length; i++) {
                if(employeeBook[i] == null) {
                    continue;
                }
                if(name.equalsIgnoreCase(employeeBook[i].getFullName())){
                    return i;
                }
            }
        }
        return -1;
    }


    //----------------------------------------

    public void removeEmployee(int id){
        if (getPosition(id) >= 0) {
            employeeBook[getPosition(id)] = null;
        }
    }

    public void removeEmployee(String name){
        if (getPosition(name) >= 0) {
            employeeBook[getPosition(name)] = null;
        }
    }



}