package cool.stories.tooth.console;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by ReaktorDTR on 06/01/17.
 */
public class PrintLikePro {

    public static void println(String value, Integer interval) {
        char[] chars = value.toCharArray();
        Random random = new Random();
        try {
            TimeUnit.MILLISECONDS.sleep(interval);
            for (int index = 0; index < chars.length; index++) {
                char singleChar = chars[index];
                ConsoleStyle.setStyle(Style.BOLD).setColor(Color.YELLOW);

                Long intervalRand = Long.valueOf(random.nextInt(interval));
                TimeUnit.MILLISECONDS.sleep(intervalRand);
                System.out.print(singleChar);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ConsoleStyle.resetColor();
        System.out.println();
    }

}
