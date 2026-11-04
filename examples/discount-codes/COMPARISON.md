# Discount Code Implementation Comparison

## Version A

Discount-code recognition is implemented directly inside `Calculator.calculateBill()` using a `switch` statement.

The same file also contains unrelated billing logic, including subtotal calculation, loyalty discounts, tax calculation, tip calculation, and total calculation.

This means the discount-code change is mixed with existing billing functionality.

## Version B

Discount-code recognition is moved into a separate `DiscountCodes` class. The `Calculator.calculateBill()` method delegates discount-code processing to `DiscountCodes.apply()`.

The `Calculator` class still contains the existing billing logic for subtotal, loyalty discounts, tax, tips, and the final bill.

However, the discount-code recognition itself is isolated from that logic.

## Conclusion

Version B makes it easier to rule out the discount-code change as the cause of a tax-calculation bug.

In Version A, discount-code recognition and tax calculation are located in the same method, making it harder to determine whether a change to that method introduced the bug.

In Version B, discount-code recognition is handled by a separate class. A tax-calculation bug can therefore be investigated independently of the discount-code implementation, making the change easier to review and debug.