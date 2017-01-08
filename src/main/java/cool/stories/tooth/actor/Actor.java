package cool.stories.tooth.actor;

import cool.stories.tooth.console.PrintLikePro;

/**
 * Created by ReaktorDTR on 06/01/17.
 */
public abstract class Actor implements BaseActor {

    private static final String STATE_PATTERN = "%s %s";
    private static final String TO_PATTERN = "%s до %s";

    private final String name;

    private State state;

    protected Actor() {
        name = "Unknown";
        state = State.WAIT;
    }

    protected Actor(String name) {
        this.name = name;
        state = State.WAIT;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String getStateDescription() {
        return String.format(STATE_PATTERN, name, state.getState());
    }

    protected String getFormattedStateDescription() {
        return String.format(STATE_PATTERN, name, state.getFormattedState());
    }

    private void printState() {
        System.out.println(getFormattedStateDescription());
    }

    @Override
    public void say(String phrase) {
        state = State.SAY;
        System.out.print(getFormattedStateDescription() + ": ");
        PrintLikePro.println(phrase, 50);
    }

    @Override
    public void walk() {
        state = State.WALK;
        printState();
    }

    @Override
    public void walk(BaseActor actor) {
        state = State.WALK;
        System.out.println(String.format(TO_PATTERN, getFormattedStateDescription(), actor.getName()));
    }

    @Override
    public void fallOnMoroz() {
        state = State.MOROZ;
        printState();
    }

    @Override
    public void startPhilosophy() {
        state = State.PHILOSOPH;
        printState();
    }


}
