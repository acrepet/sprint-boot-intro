package fr.emse.majeureinfo.springbootintro.dao;

import fr.emse.majeureinfo.springbootintro.model.Noise;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DAO for the {@link fr.emse.majeureinfo.springbootintro.model.Noise} entity
 * @author A Crepet
 */
public interface NoiseDao extends JpaRepository<Noise, Long> {
}
