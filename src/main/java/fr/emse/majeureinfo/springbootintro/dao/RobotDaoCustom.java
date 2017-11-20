package fr.emse.majeureinfo.springbootintro.dao;

import fr.emse.majeureinfo.springbootintro.model.Robot;

import java.util.List;

/**
 * Custom methods of {@link RobotDao}
 * @author A Crepet
 */
public interface RobotDaoCustom {
    public List<Robot> findWithOnSensors();
}

