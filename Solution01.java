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

class StudentTicket extends Ticket {
    public StudentTicket(double basePrice) {
        super(basePrice);
    }
    
    @Override
    public String getDescription() {
        return "student ticket";
    }
    
    @Override
    public double getPrice() {
        return getBasePrice() / 2;
    }
}

// Escreva a classe SeniorTicket aqui, herdando de Ticket

public class Solution01 {
    public static void main(String[] args) {
        // Garante o ponto como separador decimal, qualquer que seja o idioma do computador
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        double basePrice = Double.parseDouble(scanner.next());
        Ticket[] tickets = new Ticket[n];

        // Cada linha traz um tipo e uma quantidade, e o array recebe um objeto por ingresso
        int filled = 0;
        while (filled < n) {
            String type = scanner.next();
            int quantity = Integer.parseInt(scanner.next());
            for (int i = 0; i < quantity && filled < n; i++) {
                if (type.equals("STUDENT")) {
                    tickets[filled] = new StudentTicket(basePrice);
                } else if (type.equals("SENIOR")) {
                    tickets[filled] = new SeniorTicket(basePrice);
                } else {
                    tickets[filled] = new Ticket(basePrice);
                }
                filled++;
            }
        }
        scanner.close();

        printReceipt(tickets);
    }

    // Escreva o método printReceipt aqui
}
