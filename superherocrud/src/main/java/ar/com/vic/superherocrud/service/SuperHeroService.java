package ar.com.vic.superherocrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.vic.superherocrud.enums.LogType;
import ar.com.vic.superherocrud.model.SuperHero;
import ar.com.vic.superherocrud.repositories.SuperHeroRepository;
import ar.com.vic.superherocrud.util.UtilLog;

@Service
public class SuperHeroService {
	@Autowired
	SuperHeroRepository superHeroRepository;
	
	public List<SuperHero> getAllSuperHeros() {
		UtilLog.registrarInfo(this.getClass(), LogType.INFO, "log manual: llamada getAllSuperheroes");
		return superHeroRepository.findAll();
	}

	public SuperHero getSuperHeroById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public SuperHero getSuperHeroByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public SuperHero addSuperHero(SuperHero superHero) {
		// TODO Auto-generated method stub
		return null;
	}

	public String delSuperHero(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public SuperHero updSuperHero(SuperHero superHero) {
		// TODO Auto-generated method stub
		return null;
	}

	public SuperHero getSuperHeroByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
