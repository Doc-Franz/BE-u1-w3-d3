package org.example;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.EventoDAO;
import org.example.dao.LocationDAO;
import org.example.dao.PartecipazioneDAO;
import org.example.dao.PersonaDAO;
import org.example.entities.Evento;
import org.example.entities.Location;
import org.example.entities.Partecipazione;
import org.example.entities.Persona;
import org.example.enumeration.Sesso;
import org.example.enumeration.TipoEvento;
import org.example.enumeration.TipoStato;

import java.time.LocalDate;

public class Main 
{
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
    private static EntityManager em = emf.createEntityManager();

    public static void main( String[] args ) {
        EventoDAO eventoDAO = new EventoDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);
        Faker faker = new Faker();

        Location l1 = new Location(faker.name().name(), faker.address().city());
        //locationDAO.save(l1);

        Persona p1 = new Persona(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                LocalDate.of(1994, 2, 25),
                Sesso.MASCHIO
                );

        personaDAO.save(p1);

       /* Evento e1 = new Evento(
                LocalDate.now(),
                "Finale di coppa",
                40,
                TipoEvento.PRIVATO,
                faker.name().name(),
                locationDAO.getById(1)
        );*/

        //eventoDAO.save(e1);

        Partecipazione pt1 = new Partecipazione(personaDAO.getById(2), eventoDAO.getById(102), TipoStato.CONFERMATA);
        partecipazioneDAO.save(pt1);

    }
}
