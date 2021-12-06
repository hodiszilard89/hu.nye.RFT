package com.example.hunyerft.service;

import com.example.hunyerft.domain.User;
import com.example.hunyerft.domain.Vizsga;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserService {
    User findByNev(String nev);
    void addVizsga(User user, Vizsga vizsga);

    List<Vizsga> getVizsgak(User user);


    void deleteFelvettVizsga(User u, Vizsga vizsga);
}
