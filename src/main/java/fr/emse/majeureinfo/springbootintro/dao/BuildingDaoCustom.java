package fr.emse.majeureinfo.springbootintro.dao;

import fr.emse.majeureinfo.springbootintro.model.Light;

import java.util.List;

/**
 * Custom methods of {@link BuildingDao}
 * @author A Crepet
 */
public interface BuildingDaoCustom {
    public List<BuildingWithRoomsCountersDTO> findWithCountedRooms();

}
