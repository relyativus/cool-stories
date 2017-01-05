package cool.stories.tooth.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Utility to format application's prices
 */
public class PriceFormatter {

    public static String format(final BigDecimal value) {
        return value.setScale(2, RoundingMode.HALF_DOWN).toPlainString();
    }
}
