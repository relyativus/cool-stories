package cool.stories.tooth.actor;

import cool.stories.tooth.common.PriceFormatter;
import cool.stories.tooth.product.Product;

import java.math.BigDecimal;

/**
 * Represents typical girl in short skirt
 * which is good for selling products to lonely
 * boys
 */
public class GirlWithShortSkirt extends SellerActor {
    private static final String SELLER_PHRASE = "Привіт. Чи не бажали б ви купити %s. " +
            "Дуже хороший виробник. Коштує всього %s";

    private Product product;

    private BigDecimal earnedMoney = BigDecimal.ZERO;

    private boolean hasProduct;

    public GirlWithShortSkirt() {
        super("Дєвочка в коротенькій юпочці");
    }

    @Override
    public void setTargetProduct(Product product) {
        this.product = product;
        hasProduct = true;
    }

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public void sellProduct(Buyer buyer) {
        if (hasProduct) {
            walk(buyer);
            say(String.format(SELLER_PHRASE, product.getName(), PriceFormatter.format(product.getPrice())));
            buyer.checkProduct(product);
            sellProductIfInterested(buyer);
        }
    }

    @Override
    public boolean isProductSold() {
        return !hasProduct && earnedMoney.compareTo(BigDecimal.ZERO) > 0;
    }

    @Override
    public void sayResult() {
        if (isProductSold()) {
            say("Ура! Продукт продано ^_^");
        } else {
            say("Йду я від вас...");
            walk();
            setState(State.GONE);
        }
    }

    private void sellProductIfInterested(Buyer buyer) {
        if (buyer.isInterested()) {
            earnedMoney = earnedMoney.add(buyer.buyProduct(product));
            hasProduct = false;
            product = null;
            say("Дуже дякую. Ти такий класний... Не хочеш заїхати до мене?");
        }
    }


}
