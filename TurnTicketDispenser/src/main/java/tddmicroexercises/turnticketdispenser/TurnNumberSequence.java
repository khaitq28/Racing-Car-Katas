package tddmicroexercises.turnticketdispenser;

import java.util.concurrent.atomic.AtomicInteger;

public class TurnNumberSequence {
    private TurnNumberSequence() {

    }
    private static final AtomicInteger _turnNumber = new AtomicInteger(0);

    public static int getNextTurnNumber() {
        return _turnNumber.getAndIncrement();
    }
}
