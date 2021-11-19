package ar.com.vic.superherocrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.vic.superherocrud.model.SuperHero;
import ar.com.vic.superherocrud.repositories.SuperHeroRepository;

@Service
public class SuperHeroService {
	@Autowired
	SuperHeroRepository superHeroRepository;
	
	public List<SuperHero> getAllSuperHeros() {
		return superHeroRepository.findAll();
	}

}
