package fr.emse.majeureinfo.springbootintro.dao;

import fr.emse.majeureinfo.springbootintro.model.Sensor;

import java.util.List;
/**
 * Custom methods of {@link SensorDao}
 * @author A Crepet
 */
public interface SensorDaoCustom {
    public List<Sensor> findOnSensors();

}
