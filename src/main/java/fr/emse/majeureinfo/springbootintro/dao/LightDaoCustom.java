package fr.emse.majeureinfo.springbootintro.dao;

import fr.emse.majeureinfo.springbootintro.model.Light;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * Custom methods of {@link LightDao}
 * @author A Crepet
 */
public interface LightDaoCustom {
    public List<Light> findOnLights();

}
