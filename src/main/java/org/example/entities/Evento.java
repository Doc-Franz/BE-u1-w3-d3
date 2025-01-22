package org.example.entities;

import jakarta.persistence.*;
import org.example.enumeration.TipoEvento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "eventi")

public class Evento {

    @Id
    @GeneratedValue
    private Long eventoId;
    @Column(nullable = false)
    private LocalDate data_evento;
    @Column(nullable = false)
    private String descrizione;
    @Column
    private int numero_massimo_partecipanti;
    @Column
    private TipoEvento tipoEvento;
    @Column(nullable = false)
    private String titolo;

    @OneToMany(mappedBy = "evento")
    private List<Persona> listaInvitati = new ArrayList<>();

    public Evento() {};

    public Evento(LocalDate data_evento, String descrizione, int numero_massimo_partecipanti, TipoEvento tipoEvento, String titolo, List<Persona> listaInvitati) {
        this.data_evento = data_evento;
        this.descrizione = descrizione;
        this.numero_massimo_partecipanti = numero_massimo_partecipanti;
        this.tipoEvento = tipoEvento;
        this.titolo = titolo;
        this.listaInvitati = listaInvitati;
    }

    public Long getId() {
        return eventoId;
    }

    public void setId(Long id) {
        this.eventoId = id;
    }

    public LocalDate getData_evento() {
        return data_evento;
    }

    public void setData_evento(LocalDate data_evento) {
        this.data_evento = data_evento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getNumero_massimo_partecipanti() {
        return numero_massimo_partecipanti;
    }

    public void setNumero_massimo_partecipanti(int numero_massimo_partecipanti) {
        this.numero_massimo_partecipanti = numero_massimo_partecipanti;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + eventoId +
                ", data_evento=" + data_evento +
                ", descrizione='" + descrizione + '\'' +
                ", numero_massimo_partecipanti=" + numero_massimo_partecipanti +
                ", tipoEvento=" + tipoEvento +
                ", titolo='" + titolo + '\'' +
                '}';
    }
}
