package fr.emse.majeureinfo.springbootintro.web;

import fr.emse.majeureinfo.springbootintro.model.Sensor;
import fr.emse.majeureinfo.springbootintro.model.Status;

public class SensorDto {

    private final Long id;
    private final Integer signal;
    private final Status status;

    public SensorDto(Sensor sensor) {
        this.id = sensor.getId();
        this.signal = sensor.getSignal();
        this.status = sensor.getStatus();
    }

    public Long getId() {
        return id;
    }

    public Integer getSignal() {
        return signal;
    }

    public Status getStatus() {
        return status;
    }
}
