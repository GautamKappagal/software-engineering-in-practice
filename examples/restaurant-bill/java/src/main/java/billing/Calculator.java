package billing;

import java.util.List;

public class Calculator {
  public static class Item {
    String name;
    double price;
    int qty;

    public Item(String name, double price, int qty) {
      this.name = name;
      this.price = price;
      this.qty = qty;
    }
  }

  public static class Bill {
    double subtotal;
    double discount;
    double tax;
    double tip;
    double total;

    public Bill(double subtotal, double discount, double tax, double tip, double total) {
      this.subtotal = subtotal;
      this.discount = discount;
      this.tax = tax;
      this.tip = tip;
      this.total = total;
    }
  }

  public static double calculateSubtotal(List<Item> items) {
    double subtotal = 0;

    for (Item item : items) {
      subtotal += item.price * item.qty;
    }

    return subtotal;
  }

  public static double calculateDiscount(double subtotal) {
    if (subtotal >= 50) return subtotal * 0.10;

    return 0;
  }

  public static double calculateTax(double subtotal) {
    return subtotal * 0.08;
  }

  public static double calculateTip(double amount, double tipRate) {
    return amount * tipRate;
  }

  public static Bill calculateBill(List<Item> items, double tipRate) {
    double subtotal = calculateSubtotal(items);
    double discount = calculateDiscount(subtotal);
    double tax = calculateTax(subtotal - discount);
    double tip = calculateTip(subtotal - discount, tipRate);
    double total = subtotal - discount + tax + tip;

    return new Bill(subtotal, discount, tax, tip, total);
  }
}
