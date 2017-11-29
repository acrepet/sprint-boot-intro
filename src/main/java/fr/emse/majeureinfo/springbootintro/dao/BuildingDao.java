package fr.emse.majeureinfo.springbootintro.dao;

import fr.emse.majeureinfo.springbootintro.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DAO for the {@link Building} entity
 * @author A Crepet
 */
public interface BuildingDao extends JpaRepository<Building, Long>, BuildingDaoCustom {
}

