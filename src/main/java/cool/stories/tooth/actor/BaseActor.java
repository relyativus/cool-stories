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
     * Sets state of actor.
     *
     * @param state state
     */
    void setState(State state);

    /**
     * Get actors state
     *
     * @return actors state description
     */
    String getStateDescription();

    /**
     * Say something.
     *
     * @param phrase phrase
     */
    void say(String phrase);

    /**
     * Walk somewhere.
     */
    void walk();

    /**
     * Walk to someone.
     *
     * @param baseActor character of story
     */
    void walk(BaseActor baseActor);

    /**
     * Emmm nu ok state.
     */
    void fallOnMoroz();

    /**
     * 2b or !2b.
     */
    void startPhilosophy();
}
