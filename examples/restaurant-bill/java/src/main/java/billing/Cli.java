package billing;

import java.util.List;

public class Cli {
    public static void run(List<Calculator.Item> items, double tipRate) {
        Calculator.Bill bill = Calculator.calculateBill(items, tipRate);

        System.out.println("Receipt");
        System.out.println("-------");

        for (Calculator.Item item: items) {
            double lineTotal = item.price * item.qty;
            System.out.printf("%s: %d x $%.2f = $%.2f%n", item.name, item.qty, item.price, lineTotal);
        }

        System.out.printf("Subtotal: $%.2f%n", bill.subtotal);
        System.out.printf("Discount: -$%.2f%n", bill.discount);
        System.out.printf("Tax: $%.2f%n", bill.tax);
        System.out.printf("Tip: $%.2f%n", bill.tip);
        System.out.printf("Total: $%.2f%n", bill.total);
    }
}
