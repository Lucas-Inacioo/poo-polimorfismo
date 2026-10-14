import java.util.*;

public class Solution02 {
    public static void main(String[] args) {
        // Garante o ponto como separador decimal, qualquer que seja o idioma do computador
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String firstName = scanner.next();
            String lastName = scanner.next();
            String socialSecurityNumber = scanner.next();

            if (type.equals("SALARIED")) {
                double weeklySalary = Double.parseDouble(scanner.next());
                employees[i] = new SalariedEmployee(firstName, lastName, socialSecurityNumber, weeklySalary);
            } else if (type.equals("HOURLY")) {
                double wage = Double.parseDouble(scanner.next());
                double hours = Double.parseDouble(scanner.next());
                employees[i] = new HourlyEmployee(firstName, lastName, socialSecurityNumber, wage, hours);
            } else {
                double grossSales = Double.parseDouble(scanner.next());
                double commissionRate = Double.parseDouble(scanner.next());
                employees[i] = new CommissionEmployee(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
            }
        }
        scanner.close();

        double total = 0;
        for (Employee employee : employees) {
            // A variável é do tipo Employee, mas toString e earnings são os da classe real do objeto
            System.out.println(employee);
            System.out.printf("earned: %.2f%n", employee.earnings());
            total += employee.earnings();
        }
        System.out.printf("total payroll: %.2f%n", total);
    }
}
