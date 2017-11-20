package fr.emse.majeureinfo.springbootintro.web;

import fr.emse.majeureinfo.springbootintro.model.Actuator;
import fr.emse.majeureinfo.springbootintro.model.Robot;
import fr.emse.majeureinfo.springbootintro.model.Sensor;

public class RobotDto {

    private final Long id;
    private final Sensor sensor;
    private final Actuator actuator;

    public RobotDto(Robot robot) {
        this.id = robot.getId();
        this.sensor = robot.getSensor();
        this.actuator = robot.getActuator();
    }

    public Long getId() {
        return id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public Actuator getActuator() {
        return actuator;
    }

}
