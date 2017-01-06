package cool.stories.tooth.console;

/**
 * Created by ReaktorDTR on 06/01/17.
 */
public enum Style {

    RESET("\u001B[0m"),
    BOLD("\u001B[1m"),
    ITALIC("\u001B[3m"),
    UNDERLINE("\u001B[4m");

    private String ansiStyle;

    Style(String ansiStyle) {
        this.ansiStyle = ansiStyle;
    }

    public String getAnsiStyle() {
        return ansiStyle;
    }

}