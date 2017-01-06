package cool.stories.tooth.actor;

import cool.stories.tooth.console.Color;
import cool.stories.tooth.console.Style;

/**
 * Enumerate of actor's states
 */
public enum State {

    SAY("говорить", Color.BLUE),
    STAY("стоїть", Color.GREEN),
    THINK("думає", Color.CYAN),
    WALK("йде", Color.GREEN),
    GONE("пішла", Color.RED),
    SIT("сидить", Color.CYAN),
    WAIT("чекаю своєї черги", Color.CYAN),
    PHILOSOPH("почав філософствувати", Color.RED),
    MOROZ("починає морозитись", Color.RED),
    TELL("розказує історію", Color.GREEN);

    private String state;
    private Color color;

    State(String state, Color color) {
        this.state = state;
        this.color = color;
    }

    public String getState() {
        return state;
    }

    public Color getColor() {
        return color;
    }

    public String getFormattedState() {
        return color.getAnsiColor() + state + Style.RESET.getAnsiStyle();
    }
}
