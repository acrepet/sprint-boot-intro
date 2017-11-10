package fr.emse.majeureinfo.springbootintro.dao;

import fr.emse.majeureinfo.springbootintro.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DAO for the {@link fr.emse.majeureinfo.springbootintro.model.Room} entity
 * @author A Crepet
 */
public interface RoomDao extends JpaRepository<Room, Long>{
}
