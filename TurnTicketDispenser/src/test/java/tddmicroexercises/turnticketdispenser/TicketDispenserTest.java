package tddmicroexercises.turnticketdispenser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketDispenserTest {

    private TicketDispenser dispenser;
    @BeforeEach
    void setup() {
        dispenser  = new TicketDispenser();
    }
    @Test
    void foo() {
        TurnTicket ticket = dispenser.getTurnTicket();
        int cur = ticket.getTurnNumber();
        ticket = dispenser.getTurnTicket();
        assertEquals(cur+1, ticket.getTurnNumber());
    }

    @Test
    void tickets() {
        TicketDispenser dispenser = new TicketDispenser();
        for (int i = 0; i < 100 ; i++) {
            TurnTicket ticket = dispenser.getTurnTicket();
            assertEquals(i, ticket.getTurnNumber());
        }
    }

    @Test
    void multipleTickets() {
        TicketDispenser d1 = new TicketDispenser();
        TicketDispenser d2 = new TicketDispenser();
        TicketDispenser d3 = new TicketDispenser();
        for (int i = 0; i < 100 ; i++) {
            TurnTicket t1 = d1.getTurnTicket();
            TurnTicket t2 = d2.getTurnTicket();
            TurnTicket t3 = d3.getTurnTicket();
            assertTrue(t1.getTurnNumber() != t2.getTurnNumber());
            assertTrue(t1.getTurnNumber() != t3.getTurnNumber());

        }

    }
}
