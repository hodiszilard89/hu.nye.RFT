package com.example.hunyerft.service;



import com.example.hunyerft.domain.User;
import com.example.hunyerft.domain.Vizsga;
import com.example.hunyerft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService, UserDetailsService  {

	private UserRepository userRepository;


	public UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = findByNev(username);
		if( user == null ){
			throw new UsernameNotFoundException(username);
		}
		
		return new UserDetailsImpl(user);
	}

	@Override
	public User findByNev(String nev) {
		return userRepository.findByNev(nev);
	}

	@Override
	public void addVizsga(User user, Vizsga vizsga) {
		user.getVizsgak().add(vizsga);
		userRepository.save(user);
	}

	public List<Vizsga> getVizsgak(User user) {
		Set<Vizsga> set= user.getVizsgak();
		List<Vizsga> result = new ArrayList<>();
		for (Vizsga v: set) {
			result.add(v);
		}


		return result;
	}

	@Override
	public void deleteFelvettVizsga(User u, Vizsga vizsga) {
		u.getVizsgak().remove(vizsga);
		userRepository.save(u);
	}

}
