
public class EmployeeService { //Не разобрался, как сделать наследование через class2 extends class1. Или тут это не обязательно?
        public static void printAllEmployees (Employee[] employees){
                for (Employee employee : employees) {
                        System.out.println(employee);
                }
        }

        public static int getTotalSalaryPerMonth(Employee[] employees){
                int sum = 0;
                for (Employee employee : employees) {
                        sum += employee.getSalary();
                }
                return sum;
        }

        public static Employee getCheapestEmployee(Employee[] employees){
                Employee cheapest = employees[0];
                for (int i = 0; i < employees.length - 1; i++) {
                        if(cheapest.getSalary() > employees[i+1].getSalary()){
                                cheapest = employees[i+1];
                        }
                }
                return cheapest;
        }

        public static Employee getTheMostExpensiveEmployee(Employee[] employees){
                Employee theExpensiveOne = employees[0];
                for (int i = 0; i < employees.length - 1; i++) {
                        if(theExpensiveOne.getSalary() < employees[i+1].getSalary()){
                                theExpensiveOne = employees[i+1];
                        }
                }
                return theExpensiveOne;
        }

        public static float getAvgSalary(Employee[] employees){
               return (float)getTotalSalaryPerMonth(employees)/employees.length;
        }

        public static void printAllNames(Employee[] employees){
                for (int i = 0; i < employees.length; i++) {
                        System.out.println(i+1 + ". " + employees[i].getFullName());
                }
        }

        public static void indexSalary(Employee[] employees, int indexingPercentage){  // index - может быть глаголом, так что можно))
                if(indexingPercentage <= -100){
                        throw new IllegalArgumentException("You should fire this employee, not make him suffer!");
                }
                for (Employee employee : employees) {
                        employee.setSalary(employee.getSalary() + employee.getSalary() * indexingPercentage / 100);
                }

        }
}
