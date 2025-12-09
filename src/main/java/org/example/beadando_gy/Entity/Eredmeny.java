package org.example.beadando_gy.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "eredmeny")
public class Eredmeny {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate datum;
    private Integer pilotaaz; // megfelel az int(11) a DB-ben
    private Integer helyezes;
    private String hiba;
    private String csapat;
    private String tipus;
    private String motor;

    // getter/setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDatum() { return datum; }
    public void setDatum(LocalDate datum) { this.datum = datum; }
    public Integer getPilotaaz() { return pilotaaz; }
    public void setPilotaaz(Integer pilotaaz) { this.pilotaaz = pilotaaz; }
    public Integer getHelyezes() { return helyezes; }
    public void setHelyezes(Integer helyezes) { this.helyezes = helyezes; }
    public String getHiba() { return hiba; }
    public void setHiba(String hiba) { this.hiba = hiba; }
    public String getCsapat() { return csapat; }
    public void setCsapat(String csapat) { this.csapat = csapat; }
    public String getTipus() { return tipus; }
    public void setTipus(String tipus) { this.tipus = tipus; }
    public String getMotor() { return motor; }
    public void setMotor(String motor) { this.motor = motor; }
}
