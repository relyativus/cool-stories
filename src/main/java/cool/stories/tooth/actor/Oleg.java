package cool.stories.tooth.actor;

import cool.stories.tooth.console.PrintLikePro;
import cool.stories.tooth.product.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents buyer which will buy everything
 * from a seller which looks like a girl.
 * Telling pick-up phrases is the common behaviour of this actor
 */
public class Oleg extends BuyerActor implements StoryTeller {
    private static final String PICKUP_PHRASE = "...";
    private static final String ACTOR_STATE = "Підходить до %s - %s";
    private static final String NEW_LINE = "\n";
    private static final String STORY_MESSAGE = "Сижу я, %s." +
            "\nІ тут заходить %s, сімпатічній..." +
            "\nПродає %s. \n%s" +
            "\nА я %s, і тут %s...";

    public Oleg() {
        super("Олег");
    }

    @Override
    public void checkProduct(Product product) {
        System.out.println(PICKUP_PHRASE);
    }

    @Override
    public boolean isInterested() {
        return true;
    }

    @Override
    public BigDecimal buyProduct(Product product) {
        return BigDecimal.valueOf(Long.MAX_VALUE);
    }

    @Override
    public void tellTheStory(Seller seller, List<BaseActor> storyActors) {
        String actorsNames = prepareActorNames(storyActors);
        String actorsState = prepareActorsState(storyActors);
        setState(State.TELL);
        System.out.println();
        System.out.println(getFormattedStateDescription() + ": ");
        PrintLikePro.println(
                String.format(STORY_MESSAGE,
                        actorsNames,
                        seller.getName(),
                        seller.getProduct().getName(),
                        actorsState,
                        getStateDescription(),
                        seller.getStateDescription()
                ), 100
        );
        System.out.println();
    }

    @Override
    public String getStateDescription() {
        return "чекаю своєї черги";
    }

    private String prepareActorNames(List<BaseActor> actors) {
        return actors.stream().map(BaseActor::getName)
                .collect(Collectors.joining(", "));
    }

    private String prepareActorsState(List<BaseActor> actors) {
        StringBuilder actorsState = new StringBuilder();
        actors.subList(0, actors.size() -1).forEach(actor -> {
            actorsState.append(String.format(ACTOR_STATE, actor.getName(), actor.getStateDescription()));
            actorsState.append(NEW_LINE);
        });
        return actorsState.toString();
    }
}
