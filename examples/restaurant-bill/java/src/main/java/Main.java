import java.util.List;
import billing.Calculator;
import billing.Cli;

public class Main {

    public static void main(String[] args) {
        List<Calculator.Item> items = List.of(
                new Calculator.Item("Burger", 12.50, 2),
                new Calculator.Item("Fries", 4.00, 2),
                new Calculator.Item("Soda", 2.50, 2));
        double tipRate = 0.15;

        Cli.run(items, tipRate);
    }
}
