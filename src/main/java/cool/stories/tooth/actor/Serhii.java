package cool.stories.tooth.actor;

import cool.stories.tooth.product.Product;

import java.math.BigDecimal;

/**
 * Represents buyer which isn't interested in any product
 * sellers want to sold to him.
 * Starting philosophy is the common behaviour for this actor
 */
public class Serhii implements Buyer, BaseActor {
    private static final String PHILOSOPHY_PHRASE = "%s: Бути чи не бути - от в чому питання. " +
            "Не треба мені ваш %s";
    private static final String PHILOSOPHY_STATE = "%s: Філософствую...";


    @Override
    public void checkProduct(Product product) {
        System.out.println(String.format(PHILOSOPHY_PHRASE, getName(), product.getName()));
        System.out.println(String.format(PHILOSOPHY_STATE, getName()));
    }

    @Override
    public boolean isInterested() {
        return false;
    }

    @Override
    public BigDecimal buyProduct(Product product) {
        return BigDecimal.ZERO;
    }

    @Override
    public String getName() {
        return "Сєрий";
    }

    @Override
    public String getStateDescription() {
        return "почав філософствувати";
    }
}
