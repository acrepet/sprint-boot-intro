package fr.emse.majeureinfo.springbootintro.dao;

import fr.emse.majeureinfo.springbootintro.model.Robot;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DAO for the {@link Robot} entity
 * @author A Crepet
 */
public interface RobotDao extends JpaRepository<Robot, Long>,RobotDaoCustom {
}
