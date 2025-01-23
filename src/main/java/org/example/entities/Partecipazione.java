package org.example.entities;

import jakarta.persistence.*;
import org.example.enumeration.TipoStato;

@Entity
@Table(name = "partecipazioni")

public class Partecipazione {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private TipoStato tipoStato;

    public Partecipazione(){}

    public Partecipazione(Persona persona, Evento evento, TipoStato tipoStato) {
        this.persona = persona;
        this.evento = evento;
        this.tipoStato = tipoStato;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public TipoStato getTipoStato() {
        return tipoStato;
    }

    public void setTipoStato(TipoStato tipoStato) {
        this.tipoStato = tipoStato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", tipoStato=" + tipoStato +
                '}';
    }
}
