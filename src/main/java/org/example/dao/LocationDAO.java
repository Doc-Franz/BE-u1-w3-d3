package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entities.Evento;
import org.example.entities.Location;

public class LocationDAO {

    private EntityManager em;

    public LocationDAO(EntityManager em){
        this.em = em;
    }

    public void save(Location e){
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public Location getById(long id){
        return em.find(Location.class, id);
    }

    public void delete(Location e){
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }
}
