package com.example.hunyerft.repository;

import com.example.hunyerft.domain.Vizsga;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VizsgaRepository extends CrudRepository<Vizsga,Long> {
    List<Vizsga> findAll();

    Vizsga findVizsgaById(Long id);

    @Override
    void delete(Vizsga entity);




}
