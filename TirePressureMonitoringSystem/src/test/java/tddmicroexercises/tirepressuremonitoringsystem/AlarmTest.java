package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AlarmTest {

    @Test
    public void foo() {
        Alarm alarm = new Alarm(new FakeSensorInRange());
        assertFalse(alarm.isAlarmOn());
        alarm = new Alarm(new FakeSensorOutRange());
        assertFalse(alarm.isAlarmOn());
}

    @Test
    void testAlarmOn() {
        Alarm alarm = new Alarm(new FakeSensorOutRange());
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    void testAlarmOff() {
        Alarm alarm = new Alarm(new FakeSensorInRange());
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }

}
