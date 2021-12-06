package com.example.hunyerft.repository;


import com.example.hunyerft.domain.User;

import com.example.hunyerft.domain.Vizsga;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByNev(String nev);
	
}