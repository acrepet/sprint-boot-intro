package fr.emse.majeureinfo.springbootintro.dao;

import fr.emse.majeureinfo.springbootintro.model.Sensor;
import fr.emse.majeureinfo.springbootintro.model.Status;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Implementation of {@link SensorDaoCustom}
 *
 * @author A Crepet
 */
public class SensorDaoImpl implements SensorDaoCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Sensor> findOnSensors() {
        String jpql = "select lt from Sensor lt where lt.status = :value";
        TypedQuery<Sensor> query = em.createQuery(jpql, Sensor.class);
        return query.setParameter("value", Status.ON)
                .getResultList();
    }

}
