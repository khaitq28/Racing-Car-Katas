package tddmicroexercises.tirepressuremonitoringsystem;

public class FakeSensorInRange extends Sensor {

    @Override
    public double popNextPressurePsiValue() {
        return 20d;
    }
}
