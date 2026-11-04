
package billing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void calculateSubtotalSumsMultipleItems() {
        List<Calculator.Item> items = List.of(
                new Calculator.Item("Burger", 12.50, 2),
                new Calculator.Item("Fries", 4.00, 2));

        double subtotal = Calculator.calculateSubtotal(items);

        assertEquals(33.00, subtotal, 0.01);
    }

    @Test
    void calculateDiscountReturnsZeroBelowThreshold() {
        double discount = Calculator.calculateDiscount(49.99);

        assertEquals(0.00, discount, 0.01);
    }

    @Test
    void calculateDiscountReturnsTenPercentAtThreshold() {
        double discount = Calculator.calculateDiscount(50.00);

        assertEquals(5.00, discount, 0.01);
    }

    @Test
    void calculateDiscountReturnsTenPercentAboveThreshold() {
        double discount = Calculator.calculateDiscount(100.00);

        assertEquals(10.00, discount, 0.01);
    }

    @Test
    void calculateTaxReturnsEightPercentOfAmount() {
        double tax = Calculator.calculateTax(33.00);

        assertEquals(2.64, tax, 0.01);
    }

    @Test
    void calculateTipReturnsGivenPercentageOfAmount() {
        double tip = Calculator.calculateTip(33.00, 0.10);

        assertEquals(3.30, tip, 0.01);
    }

    @Test
    void calculateTotalBillCalculatesCorrectly() {
        List<Calculator.Item> items = List.of(
                new Calculator.Item("Burger", 12.50, 2),
                new Calculator.Item("Fries", 4.00, 2),
                new Calculator.Item("Soda", 2.50, 2));

        Calculator.Bill bill = Calculator.calculateBill(items, 0.15);

        assertEquals(38.00, bill.subtotal, 0.01);
        assertEquals(0.00, bill.discount, 0.01);
        assertEquals(3.04, bill.tax, 0.01);
        assertEquals(5.70, bill.tip, 0.01);
        assertEquals(46.74, bill.total, 0.01);
    }

    @Test
    void calculateBillAppliesTaxAfterDiscountOnLargeOrder() {
        List<Calculator.Item> items = List.of(
                new Calculator.Item("Steak", 30.00, 2));

        Calculator.Bill bill = Calculator.calculateBill(items, 0.15);

        assertEquals(4.32, bill.tax, 0.01);
        assertEquals(66.42, bill.total, 0.01);
    }
}