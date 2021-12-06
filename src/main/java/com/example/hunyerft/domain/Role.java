package com.example.hunyerft.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<User> useres=new HashSet<>();


    public Role(){}//


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUseres() {
        return useres;
    }

    public void setUseres(Set<User> useres) {
        this.useres = useres;
    }

    @Override
    public String toString() {
        return "Role id= "+id+" role= "+role;
    }
}
