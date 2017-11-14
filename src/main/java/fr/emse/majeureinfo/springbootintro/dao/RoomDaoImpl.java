package fr.emse.majeureinfo.springbootintro.dao;

import fr.emse.majeureinfo.springbootintro.model.Light;
import fr.emse.majeureinfo.springbootintro.model.Room;
import fr.emse.majeureinfo.springbootintro.model.Status;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Implementation of {@link LightDaoCustom}
 *
 * @author A Crepet
 */
public class RoomDaoImpl implements RoomDaoCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Room> findWithOnLights() {
        String jpql = "select ro from Room ro where ro.light.status = :value";
        TypedQuery<Room> query = em.createQuery(jpql, Room.class);
        return query.setParameter("value", Status.ON)
                .getResultList();
    }

}
