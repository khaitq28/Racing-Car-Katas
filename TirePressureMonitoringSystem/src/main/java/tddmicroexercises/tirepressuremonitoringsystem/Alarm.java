package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    private static final double LOW_PRESSURE_THRESHOLD = 17;
    private static final double HIGH_PRESSURE_THRESHOLD = 21;
    private final Sensor sensor;

    private boolean alarmOn = false;

    public Alarm(Sensor sensor) {
        this.sensor = sensor;
    }

    public void check() {
        double psiPressureValue = sensor.popNextPressurePsiValue();
        if (psiPressureValue < LOW_PRESSURE_THRESHOLD ||  psiPressureValue > HIGH_PRESSURE_THRESHOLD) {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn() {
        return alarmOn; 
    }
}
