package cool.stories.tooth.actor;

import cool.stories.tooth.product.Product;

import java.math.BigDecimal;

/**
 * Base interface for buyer actors
 */
public interface Buyer extends BaseActor {

    /**
     * Checks product to
     * decide if buyer interested in it or not
     *
     * @param product product to check
     */
    void checkProduct(final Product product);

    /**
     * Indicates that buyer interested in product or not
     *
     * @return {@literal true} if buyer wants to buy product and {@literal false} otherwise
     */
    boolean isInterested();

    /**
     * Buys product. Buyer owns passed product
     * and gives money for that
     *
     * @param product product to buy
     * @return amount of money for product
     */
    BigDecimal buyProduct(final Product product);
}
