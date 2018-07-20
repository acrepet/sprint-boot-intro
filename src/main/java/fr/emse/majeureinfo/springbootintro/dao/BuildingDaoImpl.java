
package fr.emse.majeureinfo.springbootintro.dao;

import fr.emse.majeureinfo.springbootintro.model.Building;
import fr.emse.majeureinfo.springbootintro.model.Light;
import fr.emse.majeureinfo.springbootintro.model.Room;
import fr.emse.majeureinfo.springbootintro.model.Status;
import org.hibernate.Query;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Implementation of {@link BuildingDaoCustom}
 *
 * @author A Crepet
 */
public class BuildingDaoImpl implements BuildingDaoCustom {
    @PersistenceContext
    private EntityManager em;


    @Override
    public List<BuildingWithRoomsCountersDTO> findWithCountedRooms() {
        String jpql = "select new "+
                "   fr.emse.majeureinfo.springbootintro.dao.BuildingWithRoomsCountersDTO(" +
                " bd.id , " +
                "count(distinct rooms.id) as nb, " +
                "count(distinct roomsWithLightOn.id) as nbWithLightsOn " +
                "   ) " +
                "from Building bd " +
                "inner join bd.rooms rooms " +
                "left outer join bd.rooms roomsWithLightOn " +
                "left outer join roomsWithLightOn.light light " +
                "where light.status = :statusOn " +
                "group by bd.id";

        List<BuildingWithRoomsCountersDTO> dtos = em.createQuery(jpql, BuildingWithRoomsCountersDTO.class)
                .setParameter("statusOn", Status.ON)
                .getResultList();

        return dtos;

    }
}
