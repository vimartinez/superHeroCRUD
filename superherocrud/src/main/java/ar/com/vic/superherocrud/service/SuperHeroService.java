package ar.com.vic.superherocrud.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.vic.superherocrud.enums.LogType;
import ar.com.vic.superherocrud.errorhandler.SuperHeroException;
import ar.com.vic.superherocrud.errorhandler.SuperHeroNotFoundException;
import ar.com.vic.superherocrud.model.SuperHero;
import ar.com.vic.superherocrud.repositories.SuperHeroRepository;
import ar.com.vic.superherocrud.util.SuperHeroLog;

@Service
public class SuperHeroService {
	@Autowired
	SuperHeroRepository superHeroRepository;
	
	public List<SuperHero> getAllSuperHeros() {
		SuperHeroLog.registrarInfo(this.getClass(), LogType.INFO, "log manual: llamada getAllSuperheroes");
		return superHeroRepository.findAll();
	}

	public Optional<SuperHero> getSuperHeroById(Long id) {
		return superHeroRepository.findById(id);
	}
	
	public Iterable<SuperHero> getSuperHeroByEmail(String email) {
		return superHeroRepository.getSuperHeroByEmail(email);
	}

	public Iterable<SuperHero> getSuperHeroByName(String name) {
		return superHeroRepository.getSuperHeroByName(name);
	}

	public SuperHero addSuperHero(SuperHero superHero) {
		superHeroRepository.save(superHero);
		return superHero;
	}

	public String delSuperHero(Long id) {
		SuperHero superHero = superHeroRepository.findById(id)
				.orElseThrow(() -> new SuperHeroNotFoundException("Super héroe id="+ Long.toString(id, 10) +", No se eliminó ningún registro"));
		superHeroRepository.delete(superHero);
		return "Super Heroe eliminado";
	}
	
	public SuperHero updSuperHero(SuperHero superHeroNuevo) {
		SuperHero superHeroActual = superHeroRepository.findById(superHeroNuevo.getId())
				.orElseThrow(() -> new SuperHeroNotFoundException( "Super héroe id="+superHeroNuevo.getId() + ", No se realizó la actualización"));
		superHeroActual.setCanFly(superHeroNuevo.isCanFly());
		superHeroActual.setEmail(superHeroNuevo.getEmail());
		superHeroActual.setHealth(superHeroNuevo.getHealth());
		superHeroActual.setName(superHeroNuevo.getName());
		superHeroActual.setSpeed(superHeroNuevo.getSpeed());
		superHeroActual.setStrength(superHeroNuevo.getStrength());
		return superHeroRepository.save(superHeroActual);
		
	}

}
