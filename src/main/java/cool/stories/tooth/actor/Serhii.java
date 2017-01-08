package cool.stories.tooth.actor;

import cool.stories.tooth.product.Product;

import java.math.BigDecimal;

/**
 * Represents buyer which isn't interested in any product
 * sellers want to sold to him.
 * Starting philosophy is the common behaviour for this actor
 */
public class Serhii extends BuyerActor {
    private static final String PHILOSOPHY_PHRASE = "Бути чи не бути - от в чому питання. " +
            "Не треба мені ваш %s";

    public Serhii() {
        super("Сергій");
    }

    @Override
    public void checkProduct(Product product) {
        say(String.format(PHILOSOPHY_PHRASE, product.getName()));
        startPhilosophy();
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
