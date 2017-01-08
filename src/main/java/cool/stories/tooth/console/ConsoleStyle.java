package cool.stories.tooth.console;

/**
 * Created by ReaktorDTR on 06/01/17.
 */
public class ConsoleStyle {

    private static final ConsoleStyle INSTANCE = new ConsoleStyle();

    public static ConsoleStyle setColor(Color color) {
        System.out.print(color.getAnsiColor());
        return INSTANCE;
    }

    public static ConsoleStyle setStyle(Style style) {
        System.out.print(style.getAnsiStyle());
        return INSTANCE;
    }

    public static ConsoleStyle resetColor() {
        System.out.print(Style.RESET.getAnsiStyle());
        return INSTANCE;
    }
}
