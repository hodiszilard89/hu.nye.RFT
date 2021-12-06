package com.example.hunyerft.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column(unique = true, nullable = false)
    private String nev;

    @Column( nullable = false)
    private String password;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = {@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name ="role_id")}
    )
    private Set<Role> roles = new HashSet<>();
    private String kerNev;
    private String vezNev;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_vizsgak",
            joinColumns = {@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name ="vizsga_id")}
    )
    private Set<Vizsga> vizsgak;

    public User(){}

    public User(String nev, String vezNev, String kerNev, String password){
        this.nev=nev;
        this.vezNev=vezNev;
        this.kerNev=kerNev;
        this.password=password;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getKerNev() {
        return kerNev;
    }

    public void setKerNev(String ketNev) {
        this.kerNev = ketNev;
    }

    public String getVezNev() {
        return vezNev;
    }

    public void setVezNev(String vezNev) {
        this.vezNev = vezNev;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Vizsga> getVizsgak() {
        return vizsgak;
    }

    public void setVizsgak(Set<Vizsga> vizsgak) {
        this.vizsgak = vizsgak;
    }

    public void addVizsga(Vizsga vizsga) {
        getVizsgak().add(vizsga);
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
