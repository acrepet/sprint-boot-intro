package fr.emse.majeureinfo.springbootintro.dao;

import fr.emse.majeureinfo.springbootintro.model.Light;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DAO for the {@link fr.emse.majeureinfo.springbootintro.model.Light} entity
 * @author A Crepet
 */
public interface LightDao extends JpaRepository<Light, Long>, LightDaoCustom {
}
