package cool.stories.tooth.actor;

/**
 * Base interface for all story actors
 */
public interface BaseActor {

    /**
     * Returns actors name
     *
     * @return actor's name
     */
    String getName();

    /**
     * Get actors state
     *
     * @return actors state description
     */
    String getStateDescription();
}
