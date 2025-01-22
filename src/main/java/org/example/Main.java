package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.EventoDAO;
import org.example.entities.Evento;
import org.example.enumeration.TipoEvento;

import java.time.LocalDate;

public class Main 
{
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
    private static EntityManager em = emf.createEntityManager();

    public static void main( String[] args ) {
        System.out.println("prov");
        EventoDAO eventoDao = new EventoDAO(em);
        Evento evento1 = new Evento(LocalDate.now(), "Festa di compleanno", 30, TipoEvento.PRIVATO, "Festa");
        Evento evento2 = new Evento(LocalDate.now(), "Cinema", 100, TipoEvento.PUBBLICO, "Cinema aperto");

        //eventoDao.save(evento1);
        //eventoDao.save(evento2);


    }
}
