package tddmicroexercises.tirepressuremonitoringsystem;

public class FakeSensorOutRange extends Sensor {

    @Override
    public double popNextPressurePsiValue() {
        return 100d;
    }
}
