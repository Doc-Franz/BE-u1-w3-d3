package org.example.entities;

import jakarta.persistence.*;
import org.example.enumeration.TipoEvento;

import javax.xml.namespace.QName;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "eventi")

public class Evento {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private LocalDate data_evento;
    @Column(nullable = false)
    private String descrizione;
    private int numero_massimo_partecipanti;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    @Column(nullable = false)
    private String titolo;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> listaPartecipazioni;

    public Evento() {};

    public Evento(LocalDate data_evento, String descrizione, int numero_massimo_partecipanti, TipoEvento tipoEvento, String titolo, Location location) {
        this.data_evento = data_evento;
        this.descrizione = descrizione;
        this.numero_massimo_partecipanti = numero_massimo_partecipanti;
        this.tipoEvento = tipoEvento;
        this.titolo = titolo;
        this.location = location;
        this.listaPartecipazioni = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Partecipazione> getListaPartecipazioni() {
        return listaPartecipazioni;
    }

    public void setListaPartecipazioni(List<Partecipazione> listaPartecipazioni) {
        this.listaPartecipazioni = listaPartecipazioni;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", data_evento=" + data_evento +
                ", descrizione='" + descrizione + '\'' +
                ", numero_massimo_partecipanti=" + numero_massimo_partecipanti +
                ", tipoEvento=" + tipoEvento +
                ", titolo='" + titolo + '\'' +
                ", location=" + location +
                ", listaPartecipazioni=" + listaPartecipazioni +
                '}';
    }
}
