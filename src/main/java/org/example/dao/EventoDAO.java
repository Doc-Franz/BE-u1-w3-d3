package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Evento;

public class EventoDAO {
    private EntityManager em;

    public EventoDAO(EntityManager em){
        this.em = em;
    }

    public void save(Evento e){
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public Evento getById(long id){
        return em.find(Evento.class, id);
    }

    public void delete(Evento e){
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }

}
