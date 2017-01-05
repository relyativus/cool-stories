package cool.stories.tooth.actor;

import java.util.List;

/**
 * Base interface for actors which can tell stories
 */
public interface StoryTeller {

    /**
     * Tells the story about actors
     *
     * @param mainActor story's main actor
     * @param actors    secondary actors
     */
    void tellTheStory(final Seller mainActor, final List<BaseActor> actors);
}
