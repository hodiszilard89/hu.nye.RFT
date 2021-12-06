package com.example.hunyerft.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="vizsgak")
public class Vizsga {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String vizsgaNev;
    private String targyNev;
    private String helySzin;
    private String datum;
    private String idoPont;
    private String idoTartalom;

    @ManyToMany(mappedBy = "vizsgak")
    private Set<User> users = new HashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }



    public Vizsga(){}

    public Vizsga(String vizsgaNev, String targyNev,String helySzin,String datum,String idoPont,String idoTartalom){
        this.vizsgaNev=vizsgaNev;
        this.targyNev=targyNev;
        this.helySzin=helySzin;
        this.datum=datum;
        this.idoPont=idoPont;
        this.idoTartalom=idoTartalom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVizsgaNev() {
        return vizsgaNev;
    }

    public void setVizsgaNev(String vizsgaNeve) {
        this.vizsgaNev = vizsgaNeve;
    }

    public String getTargyNev() {
        return targyNev;
    }

    public void setTargyNev(String targyNeve) {
        this.targyNev = targyNeve;
    }

    public String getHelySzin() {
        return helySzin;
    }

    public void setHelySzin(String helySzin) {
        this.helySzin = helySzin;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getIdoPont() {
        return idoPont;
    }

    public void setIdoPont(String idoPont) {
        this.idoPont = idoPont;
    }

    public String getIdoTartalom() {
        return idoTartalom;
    }

    public void setIdoTartalom(String idoTartalom) {
        this.idoTartalom = idoTartalom;
    }
}
