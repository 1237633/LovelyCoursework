public class EmployeeBook {
    private Employee[] employeeBook;
    private final int NUMBER_OF_DEPARTMENTS = 5;
    private final int FIRST_DEPARTMENT = 1;
    private final int MIN_SALARY = 100000;
    private final int MAX_SALARY = 200000;
    public EmployeeBook(int length){
        employeeBook = new Employee[length];
    }


    public boolean depIsNotNull(int depId){
        return getAllEmployeesOfDepartment(depId) != null;
    }


    public void fillWithRandom(){
        for (int i = 0; i < employeeBook.length; i++) {
            employeeBook[i] = new Employee(RandomTools.generateRandomName(), RandomTools.generateRandomNumber(FIRST_DEPARTMENT, NUMBER_OF_DEPARTMENTS+1), RandomTools.generateRandomNumber(MIN_SALARY, MAX_SALARY));
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

    public void printAllNames(){
        int count = 0;
        for (Employee employee: employeeBook) {
            if(employee != null) {
                System.out.println(count + 1 + ". " + employee.getFullName());
                count++;
            }
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
            return getAllEmployeesOfDepartment(departmentId).getAvgSalary();
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

    public int getPosition(String nameOrId){
        if(employeeBook != null && nameOrId != null){
            boolean idEquals;
            boolean nameEquals;
            for (int i = 0; i < employeeBook.length; i++) {

                if(employeeBook[i] == null) {
                    continue;
                }

                idEquals = nameOrId.replace(" ", "").equals(Integer.toString(employeeBook[i].getId()).replace(" ", ""));
                nameEquals = nameOrId.replace(" ", "").equalsIgnoreCase(employeeBook[i].getFullName().replace(" ", ""));


                if(idEquals || nameEquals){
                    return i;
                }
            }
        }
        return -1;
    }

    public int findEmpty(){                             // returns 1st empty element
        for (int i = 0; i < employeeBook.length; i++) {
            if(employeeBook[i] == null){
                return i;
            }
        }
        return -1;
    }


    //----------------------------------------

    public void removeEmployee(String nameOrId){
        if (getPosition(nameOrId) >= 0) {
            employeeBook[getPosition(nameOrId)] = null;
        } else {
            System.out.println("There is no such employee!");
        }

    }


    public void addEmployee(String name, int departmentId, int salary){
        if(findEmpty() >= 0){
            employeeBook[findEmpty()] = new Employee(name, departmentId, salary);
        } else {
            System.out.println("Not enough space! EmployeeBook doesn't change.");
        }
    }

    public void setSalary(String name, int newSalary){
       if (getPosition(name) >= 0){
           employeeBook[getPosition(name)].setSalary(newSalary);
       } else {
           System.out.println("There is no such employee!");
       }
    }

    public void setDepartment(String name, int newDepartmentId){
        if (getPosition(name) >= 0){
            employeeBook[getPosition(name)].setDepartment(newDepartmentId);
        } else {
            System.out.println("There is no such employee!");
        }
    }

    public void printAllEmployees(boolean splitByDepartments){
        if(!splitByDepartments){
            printAllEmployees();
            return;
        }

        int departments = 0;
        for (Employee employee: employeeBook) {          //we can use NUMBER_OF_DEPARTMENTS, but in real proj we might not know number of dep's
            if(employee != null && employee.getDepartmentId() > departments){
                departments = employee.getDepartmentId();
            }
        }
        if(departments < FIRST_DEPARTMENT){
            return;
        }
        for (int i = FIRST_DEPARTMENT; i <= departments; i++) {
            if(getAllEmployeesOfDepartment(i) == null){
                continue;
            }
            System.out.println("Department " + i + ": ");
            printAllEmployees(i);
        }

        }

    }


