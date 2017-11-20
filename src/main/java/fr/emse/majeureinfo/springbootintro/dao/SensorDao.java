package fr.emse.majeureinfo.springbootintro.dao;

import fr.emse.majeureinfo.springbootintro.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DAO for the {@link Sensor} entity
 * @author A Crepet
 */
public interface SensorDao extends JpaRepository<Sensor, Long>, SensorDaoCustom {
}
