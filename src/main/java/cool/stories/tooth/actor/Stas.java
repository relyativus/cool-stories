package cool.stories.tooth.actor;

import cool.stories.tooth.common.PriceFormatter;
import cool.stories.tooth.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a buyer which doesn't want to
 * spend much money. He buys the product only
 * when product price is less than {@link #PRICE_LIMIT} and when he
 * has enough money in his wallet.
 * Freezing is common behaviour for this actor
 */
public class Stas implements Buyer {
    private static final String EXPENSIVE_PHRASE = "%s: Хммм... %s дуже дорого за %s. Я не буду купувати";
    private static final String FREEZE_PHRASE = "%s: Морожусь...";
    private static final String BUYER_PHRASE = "%s: Хм...Це цікаво. Мабуть, я куплю %s";
    private static final BigDecimal PRICE_LIMIT = BigDecimal.TEN;

    private boolean interested = false;
    private BigDecimal wallet = BigDecimal.TEN;
    private List<Product> products = new ArrayList<>();

    @Override
    public void checkProduct(Product product) {
        if (product.getPrice().compareTo(PRICE_LIMIT) > 0 && hasMoney()) {
            System.out.println(String.format(EXPENSIVE_PHRASE, getName(), PriceFormatter.format(product.getPrice()),
                    product.getName()));
            System.out.println(String.format(FREEZE_PHRASE, getName()));
            this.interested = false;
        } else {
            System.out.println(String.format(BUYER_PHRASE, getName(), product.getName()));
            this.interested = true;
        }
    }

    @Override
    public boolean isInterested() {
        return interested;
    }

    @Override
    public BigDecimal buyProduct(Product product) {
        this.products.add(product);
        this.wallet = this.wallet.min(product.getPrice());
        return product.getPrice();
    }

    @Override
    public String getName() {
        return "Cтас";
    }

    @Override
    public String getStateDescription() {
        return "починає морозитись";
    }

    private boolean hasMoney() {
        return wallet.compareTo(PRICE_LIMIT) >= 0;
    }


}
