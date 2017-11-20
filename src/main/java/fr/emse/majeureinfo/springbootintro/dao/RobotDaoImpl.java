package fr.emse.majeureinfo.springbootintro.dao;

import fr.emse.majeureinfo.springbootintro.model.Robot;
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
public class RobotDaoImpl implements RobotDaoCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Robot> findWithOnSensors() {
        String jpql = "select ro from Robot ro where ro.sensor.status = :value";
        TypedQuery<Robot> query = em.createQuery(jpql, Robot.class);
        return query.setParameter("value", Status.ON)
                .getResultList();
    }

}
