package cool.stories.tooth.actor;

import cool.stories.tooth.product.Product;

/**
 * Base interface for seller actors.
 */
public interface Seller extends BaseActor {

    /**
     * Link product with seller
     *
     * @param product product to sell
     */
    void setTargetProduct(final Product product);

    /**
     * Returns product this seller sells
     *
     * @return product
     */
    Product getProduct();

    /**
     * Try to sell product to buyer
     *
     * @param buyer buyer to sell product to
     */
    void sellProduct(final Buyer buyer);

    /**
     * Indicates if seller sold product
     *
     * @return {@literal true} if associated product has been sold or {@literal false} otherwise
     */
    boolean isProductSold();

    /**
     * Seller describes his work
     */
    void sayResult();
}
