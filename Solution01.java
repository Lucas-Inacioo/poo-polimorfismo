import java.util.*;

class Ticket {
    private double basePrice;

    public Ticket(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getDescription() {
        return "regular ticket";
    }

    public double getPrice() {
        return basePrice;
    }
}

// Escreva a classe StudentTicket aqui, herdando de Ticket

// Escreva a classe SeniorTicket aqui, herdando de Ticket

public class Solution01 {
    public static void main(String[] args) {
        // Garante o ponto como separador decimal, qualquer que seja o idioma do computador
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        Ticket[] tickets = new Ticket[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double basePrice = Double.parseDouble(scanner.next());
            if (type.equals("STUDENT")) {
                tickets[i] = new StudentTicket(basePrice);
            } else if (type.equals("SENIOR")) {
                tickets[i] = new SeniorTicket(basePrice);
            } else {
                tickets[i] = new Ticket(basePrice);
            }
        }
        scanner.close();

        double total = 0;
        for (Ticket ticket : tickets) {
            // A variável é do tipo Ticket, mas o método executado é o da classe real do objeto
            System.out.printf("%s: %.2f%n", ticket.getDescription(), ticket.getPrice());
            total += ticket.getPrice();
        }
        System.out.printf("total: %.2f%n", total);
    }
}
