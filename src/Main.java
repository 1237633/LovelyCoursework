public class Main {
    public static void main(String[] args) {
        Employee[] employeeBook = new Employee[10];
        System.out.println(RandomTools.generateRandomName());

      for (int i = 0; i < 10; i++) {
          employeeBook[i] = new Employee(RandomTools.generateRandomName(), RandomTools.generateRandomDepartmentId(), RandomTools.generateRandomNumber(200000));
          //System.out.println(employeeBook[i]);
      }
    }
}

