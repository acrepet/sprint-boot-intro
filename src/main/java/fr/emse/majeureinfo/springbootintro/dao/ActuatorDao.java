package fr.emse.majeureinfo.springbootintro.dao;

import fr.emse.majeureinfo.springbootintro.model.Actuator;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DAO for the {@link Actuator} entity
 * @author A Crepet
 */
public interface ActuatorDao extends JpaRepository<Actuator, Long> {
}
