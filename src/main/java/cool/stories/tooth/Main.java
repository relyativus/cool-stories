package cool.stories.tooth;

import cool.stories.tooth.actor.*;
import cool.stories.tooth.chain.SellerChain;
import cool.stories.tooth.product.Product;
import cool.stories.tooth.product.ToothPaste;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Tooth paste story entry point
 */
public class Main {

    public static void main(String[] args) {
        final Product product = new ToothPaste(BigDecimal.valueOf(170));

        GirlWithShortSkirt seller = new GirlWithShortSkirt();
        seller.setTargetProduct(product);

        Oleg oleg = new Oleg();
        Stas stas = new Stas();
        Serhii serhii = new Serhii();
        Tolik tolik = new Tolik();

        SellerChain sellerChain = new SellerChain(seller);
        sellerChain.addBuyer(stas);
        sellerChain.addBuyer(serhii);
        sellerChain.addBuyer(oleg);
        sellerChain.addBuyer(tolik);

        sellerChain.doChain();

        oleg.tellTheStory(seller, Arrays.asList(stas, serhii, tolik));
    }
}
