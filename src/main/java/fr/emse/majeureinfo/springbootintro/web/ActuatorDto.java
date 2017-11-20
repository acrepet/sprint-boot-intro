package fr.emse.majeureinfo.springbootintro.web;

import fr.emse.majeureinfo.springbootintro.model.Actuator;
import fr.emse.majeureinfo.springbootintro.model.Status;

public class ActuatorDto {

    private final Long id;
    private final Integer speed;
    private final Status status;

    public ActuatorDto(Actuator actuator) {
        this.id = actuator.getId();
        this.speed = actuator.getSpeed();
        this.status = actuator.getStatus();
    }

    public Long getId() {
        return id;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Status getStatus() {
        return status;
    }
}
