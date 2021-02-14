import java.util.*;

public class Transaction {
    private final ArrayList<Item> cart = new ArrayList<Item>();

    enum PaymentType {
        CASH, DEBIT_CARD, CREDIT_CARD, CHECK
    }
    public Transaction(ArrayList<Item> inCart) {
        cart.addAll(inCart);
    }

    private double getSubtotal() {
        double subtotal = 0.0;
        for (Item current : cart) {
            subtotal += current.getCost();
        }
        return subtotal;
    }

    private double getTax() {
        return this.getSubtotal() * 0.07;
    }

    public void printReceipt() {
        Scanner in = new Scanner(System.in);
        double toPay;
        StringBuilder paidString = new StringBuilder();

        double total = this.getSubtotal() + this.getTax();
        double balance = total;

        for (int i = 0; i < cart.size(); i++) {
            String currentName = cart.get(i).getName();
            double currentCost = cart.get(i).getCost();
            System.out.printf("Item %d: %s: %.2f%n", i+1, currentName, currentCost);
        }

        System.out.printf("Total: %.2f%n%n", total);

        PaymentType p = PaymentType.CASH;

        while (balance > 0) {
            System.out.println("Please enter payment type: ");
            System.out.println("1) Cash");
            System.out.println("2) Debit Card");
            System.out.println("3) Credit Card");
            System.out.println("4) Check");
            int choice = in.nextInt();

            switch (choice) {
                case 1 -> {
                    p = PaymentType.CASH;
                    System.out.println("Enter the amount to pay with this type.");
                    toPay = in.nextDouble();
                    balance -= toPay;
                    System.out.printf("Total after payment: %.2f%n%n", balance);
                    paidString.append("\nCash:\t\t").append(toPay);
                }
                case 2 -> {
                    p = PaymentType.DEBIT_CARD;
                    System.out.println("Enter the amount to pay with this type.");
                    toPay = in.nextDouble();
                    balance -= toPay;
                    System.out.printf("Total after payment: %.2f%n%n", balance);
                    paidString.append("\nDebit: \t\t").append(toPay);
                }
                case 3 -> {
                    p = PaymentType.CREDIT_CARD;
                    System.out.println("Enter the amount to pay with this type.");
                    toPay = in.nextDouble();
                    balance -= toPay;
                    System.out.printf("Total after payment: %.2f%n%n", balance);
                    paidString.append("\nCredit: \t").append(toPay);
                }
                case 4 -> {
                    p = PaymentType.CHECK;
                    System.out.println("Enter the amount to pay with this type.");
                    toPay = in.nextDouble();
                    balance -= toPay;
                    System.out.printf("Total after payment: %.2f%n%n", balance);
                    paidString.append("\nCheck: \t\t").append(toPay);
                }
                default -> System.out.println("Invalid input");
            }
        }

        // Print formatted receipt:
        for (Item current : cart) {
            System.out.println(current.getName() + ": $" + current.getCost());
        }
        System.out.println("--------------------------------------------------");
        System.out.printf("Subtotal: \t%.2f%n", getSubtotal());
        System.out.printf("Tax: \t\t%.2f%n", getTax());
        System.out.printf("Total: \t\t%.2f", total);
        System.out.println(paidString);


        // If final balance payed by card, no change. Else, print absolute value of changeDue.
        if (p == PaymentType.CREDIT_CARD || p == PaymentType.DEBIT_CARD) {
            System.out.println("Change: \t0.00");
        } else {
            double changeDue = Math.abs(balance);
            System.out.printf("Change: \t%.2f%n%n", changeDue);
        }
    }
}
