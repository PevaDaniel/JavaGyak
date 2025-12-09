package org.example.beadando_gy.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "gp")
public class Gp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate datum;
    private String nev;
    private String helyszin;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDatum() { return datum; }
    public void setDatum(LocalDate datum) { this.datum = datum; }
    public String getNev() { return nev; }
    public void setNev(String nev) { this.nev = nev; }
    public String getHelyszin() { return helyszin; }
    public void setHelyszin(String helyszin) { this.helyszin = helyszin; }
}
