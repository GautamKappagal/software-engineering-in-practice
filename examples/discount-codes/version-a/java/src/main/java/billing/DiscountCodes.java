package billing;

import java.util.Map;
import java.util.function.DoubleUnaryOperator;

public class DiscountCodes {
    public static final Map<String, DoubleUnaryOperator> CODES = Map.of(
            "SAVE20", amount -> amount * 0.20,
            "SAVE10", amount -> amount * 0.10,
            "SAVE5", amount -> 5.0
    );

    public static double apply(double amount, String code) {
        DoubleUnaryOperator fn = CODES.get(code);

        if (fn == null) {
            throw new IllegalArgumentException("unknown discount code: " + code);
        }

        return fn.applyAsDouble(amount);
    }
}
