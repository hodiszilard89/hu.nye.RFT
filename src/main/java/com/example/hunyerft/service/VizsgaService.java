package com.example.hunyerft.service;

import com.example.hunyerft.domain.User;
import com.example.hunyerft.domain.Vizsga;
import com.example.hunyerft.repository.VizsgaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VizsgaService {

    VizsgaRepository vizsgaRepo;

    @Autowired
    public void setVizsgaRepo(VizsgaRepository vizsgaRepo) {
        this.vizsgaRepo = vizsgaRepo;
    }

    public List<Vizsga> getVizsgak(){
        if(!vizsgaRepo.findAll().isEmpty())
            return vizsgaRepo.findAll();
        return null;
    }



    public void init(Vizsga vizsga){
        vizsgaRepo.save(vizsga);
        System.out.println("elmentettem"+vizsga.getVizsgaNev());
    }

    public Vizsga getVizsga(Long id) {
        return vizsgaRepo.findVizsgaById(id);
    }

    public void deleteVizsga(Vizsga vizsga) {
        for (User u: vizsga.getUsers()) {
            u.getVizsgak().remove(vizsga);

        }
        vizsgaRepo.delete(vizsga);
    }
}
