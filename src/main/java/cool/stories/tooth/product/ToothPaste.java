package cool.stories.tooth.product;

import java.math.BigDecimal;

/**
 * Represents toot paste product.
 * This class defines base product properties
 * such as product price
 */
public class ToothPaste implements Product {
    private static final String TOOTH_PASTE_NAME = "зубна паста";
    private BigDecimal price;

    public ToothPaste(BigDecimal price) {
        this.price = price;
    }
    @Override
    public String getName() {
        return TOOTH_PASTE_NAME;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
