package cool.stories.tooth.actor;

import cool.stories.tooth.product.Product;

import java.math.BigDecimal;

/**
 * Represents a passive buyer.
 * Writing <strong>beranked</strong> is the common behaviour of this actor
 */
public class Tolik implements Buyer {

    @Override
    public String getName() {
        return "Толік";
    }

    @Override
    public String getStateDescription() {
        return "ще не жонатий";
    }

    @Override
    public void checkProduct(Product product) {
        //do nothing
    }

    @Override
    public boolean isInterested() {
        return false;
    }

    @Override
    public BigDecimal buyProduct(Product product) {
        return BigDecimal.ZERO;
    }
}
