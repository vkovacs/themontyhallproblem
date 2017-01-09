package hu.crs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    /**
     * Number of runs to test the strategies
     */
    private static final int MAX_TRY = 10000;
    /**
     * Element is true in case it contains the prize, otherwise it's false
     */
    private static final List<Boolean> DOORS = Arrays.asList(true, false, false);

    private static int notChangeDoorStrategyWinCount = 0;
    private static int changeDoorStrategyWinCount = 0;

    public static void main(String[] args) {

        for (int i = 0; i < MAX_TRY; i++) {
            Collections.shuffle(DOORS);
            int firstChosenDoorId = ThreadLocalRandom.current().nextInt(0,  3);

            if (DOORS.get(firstChosenDoorId)) {
                notChangeDoorStrategyWinCount++;
            } else {
                // if the first chosenDoorId does not contain the prize, the only valid other doorId which can be
                // chosen have to contain the prize (since an empty door id is revealed, which is never the chosenDoorId)
                changeDoorStrategyWinCount++;
            }
        }

        System.out.println("Run count: " + MAX_TRY);
        System.out.println("Not change strategy win count: " + notChangeDoorStrategyWinCount);
        System.out.println("Change strategy win count: " + changeDoorStrategyWinCount);
    }

}
