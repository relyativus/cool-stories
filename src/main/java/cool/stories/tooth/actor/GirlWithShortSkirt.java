package cool.stories.tooth.actor;

import cool.stories.tooth.common.PriceFormatter;
import cool.stories.tooth.product.Product;

import java.math.BigDecimal;

/**
 * Represents typical girl in short skirt
 * which is good for selling products to lonely
 * boys
 */
public class GirlWithShortSkirt implements Seller, BaseActor {
    private static final String SELLER_PHRASE = "Девочка в коротенькій юпочці: Привіт. Чи не бажали б ви купити %s. " +
            "Дуже хороший виробник. Коштує всього %s";

    private Product product;

    private BigDecimal earnedMoney = BigDecimal.ZERO;

    private boolean hasProduct;

    @Override
    public void setTargetProduct(Product product) {
        this.product = product;
        this.hasProduct = true;
    }

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public void sellProduct(Buyer buyer) {
        if (hasProduct) {
            System.out.println(String.format(SELLER_PHRASE, product.getName(),
                    PriceFormatter.format(product.getPrice())));
            buyer.checkProduct(product);
            sellProductIfInterested(buyer);
        }
    }

    @Override
    public boolean isProductSold() {
        return !hasProduct && earnedMoney.compareTo(BigDecimal.ZERO) > 0;
    }

    @Override
    public String getName() {
        return "Дєвочка в коротенькій юпочці";
    }

    @Override
    public String getStateDescription() {
        return "пішла";
    }

    @Override
    public void sayResult() {
        if (isProductSold()) {
            System.out.println(String.format("%s: Ура! Продукт продано ^_^", getName()));
        } else {
            System.out.println(String.format("%s: Йду я від вас...", getName()));
        }
    }

    private void sellProductIfInterested(final Buyer buyer) {
        if (buyer.isInterested()) {
            this.earnedMoney = earnedMoney.add(buyer.buyProduct(product));
            this.hasProduct = false;
            this.product = null;
            System.out.println("Дуже дякую. Ти такий класний... Не хочеш заїхати до мене?");
        }
    }


}
