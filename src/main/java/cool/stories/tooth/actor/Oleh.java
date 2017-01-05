package cool.stories.tooth.actor;

import cool.stories.tooth.product.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents buyer which will buy everything
 * from a seller which looks like a girl.
 * Telling pick-up phrases is the common behaviour of this actor
 */
public class Oleh implements Buyer, StoryTeller {
    private static final String PICKUP_PHRASE = "...";
    private static final String ACTOR_STATE = "Підходить до %s - %s";
    private static final String NEW_LINE = "\n";
    private static final String STORY_MESSAGE = "%s: Сижу я, %s. І тут заходить %s, сімпатічній..." +
            "\nПродає %s. \n%s" +
            "\nА я %s, і тут %s %s...";

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
    public void tellTheStory(final Seller seller, final List<BaseActor> storyActors) {
        String actorsNames = prepareActorNames(storyActors);
        String actorsState = prepareActorsState(storyActors);

        System.out.println(
                String.format(STORY_MESSAGE,
                        getName(),
                        actorsNames,
                        seller.getName(),
                        seller.getProduct().getName(),
                        actorsState,
                        getStateDescription(),
                        seller.getName(),
                        seller.getStateDescription()
                )
        );
    }

    @Override
    public String getName() {
        return "Олег";
    }

    @Override
    public String getStateDescription() {
        return "чекаю своєї черги";
    }

    private String prepareActorNames(final List<BaseActor> actors) {
        return actors.stream().map(BaseActor::getName)
                .collect(Collectors.joining(", "));
    }

    private String prepareActorsState(final List<BaseActor> actors) {
        StringBuilder actorsState = new StringBuilder();
        actors.subList(0, actors.size() -1).forEach(actor -> {
            actorsState.append(String.format(ACTOR_STATE, actor.getName(), actor.getStateDescription()));
            actorsState.append(NEW_LINE);
        });
        return actorsState.toString();
    }
}
