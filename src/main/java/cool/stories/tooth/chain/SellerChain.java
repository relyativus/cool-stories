package cool.stories.tooth.chain;

import cool.stories.tooth.actor.Buyer;
import cool.stories.tooth.actor.Seller;

import java.util.ArrayList;
import java.util.List;

/**
 * Registers potential buyers and try to sell product
 * using seller
 */
public class SellerChain {
    private static final int ATTEMPTS_COUNT = 2;

    private Seller seller;

    private List<Buyer> buyerList = new ArrayList<>();

    public SellerChain(final Seller seller) {
        this.seller = seller;
    }

    public void addBuyer(final Buyer buyer) {
        this.buyerList.add(buyer);
    }

    public void doChain() {
        for (int i = 0; i < ATTEMPTS_COUNT; i++) {
            seller.sellProduct(buyerList.get(i));
            if (seller.isProductSold()) break;
        }
        seller.sayResult();
    }

}
