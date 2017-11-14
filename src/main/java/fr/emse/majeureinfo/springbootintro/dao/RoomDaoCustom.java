package fr.emse.majeureinfo.springbootintro.dao;

import fr.emse.majeureinfo.springbootintro.model.Light;
import fr.emse.majeureinfo.springbootintro.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Custom methods of {@link RoomDao}
 * @author A Crepet
 */
public interface RoomDaoCustom {
    public List<Room> findWithOnLights();
}

